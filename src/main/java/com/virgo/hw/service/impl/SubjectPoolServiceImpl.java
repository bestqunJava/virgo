package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.dto.*;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.bean.enums.SnowflakeIdWorker;
import com.virgo.hw.bean.enums.SubjectTypeEnum;
import com.virgo.hw.bean.vo.SubjectPoolResultVO;
import com.virgo.hw.bean.vo.SubjectPoolVO;
import com.virgo.hw.exception.ServiceException;
import com.virgo.hw.feign.YouDaoApiClient;
import com.virgo.hw.mapper.SubjectPoolMapper;
import com.virgo.hw.service.ISubjectPoolService;
import com.virgo.hw.util.YouDaoSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:21 上午
 */
@Service
@Slf4j
public class SubjectPoolServiceImpl implements ISubjectPoolService {

    @Resource
    SubjectPoolMapper subjectPoolMapper;

    @Resource
    YouDaoApiClient youDaoApiClient;

    /**
     * 上传类型， 仅支持base64上传，请填写固定值1
     */
    private static final String TYPE = "1";

    /**
     * 签名类型
     */
    private static final String SIGN_TYPE = "v2";

    private static final String APP_KEY = "2c9b7712ed44c5d3";

    private static final String APP_SECRET = "3I5f2Md09vzlO0P0oblgU8ecNRDRyT0S";

    private static final String PICTURE_TYPE = "img";

    @Override
    public String insertEntity(SubjectPoolDTO dto) {
        String subjectId = SnowflakeIdWorker.takeIdString();
        SubjectPoolEntity entity = new SubjectPoolEntity();
        BeanUtils.copyProperties(dto, entity);
        subjectPoolMapper.insert(entity.setSubjectId(subjectId)
                .setCreateTime(LocalDateTime.now())
        );
        return subjectId;
    }

    @Override
    public String photoCollect(InputStream picPath) {
        String path = YouDaoSignUtil.loadAsBase64(picPath);
        String salt = String.valueOf(System.currentTimeMillis());
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        String question = APP_KEY + YouDaoSignUtil.truncate(path) + salt + curTime + APP_SECRET;
        YouDaoResponse<CollectPhotoResult> resp;
        try {
            resp = youDaoApiClient.photoCollect(new CollectPhotoDTO()
                    .setAppKey(APP_KEY)
                    .setCurtime(curTime)
                    .setQ(path)
                    .setSalt(salt)
                    .setType(TYPE)
                    .setSignType(SIGN_TYPE)
                    .setSign(YouDaoSignUtil.getDigest(question))
                    .setSearchType(PICTURE_TYPE)
            );
        } catch (Exception e) {
            log.error("搜题服务异常...");
            throw new ServiceException("搜题服务异常...", e);
        }
        if (YouDaoResponse.ok(resp)) {
            CollectPhotoResult data = resp.getData();
            return Optional.ofNullable(data).map(r -> {
                Question q = r.getQuestions().get(0);
                return this.insertEntity(new SubjectPoolDTO()
                        .setSubjectContent(q.getContent())
                        .setAnalysisContent(q.getAnalysis())
                        .setReferenceContent(q.getAnswer())
                );
            }).orElse(null);
        }
        log.error("添加试题异常{}", resp);
        throw new ServiceException("添加试题异常");
    }

    @Override
    public List<SubjectPoolVO> findEntity(SubjectQueryDTO dto) {
        Wrapper<SubjectPoolEntity> wrapper = new QueryWrapper<>(new SubjectPoolEntity()).in("subject_id", dto.getSubjectIds());
        return subjectPoolMapper.selectList(wrapper).stream().map(r -> {
            SubjectPoolVO vo = new SubjectPoolVO();
            BeanUtils.copyProperties(r, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public PageData<SubjectPoolResultVO> listSubject(SubjectQueryDTO dto) {
        final Page<SubjectPoolEntity> data = PageHelper.startPage(dto.getPage(), dto.getSize(), true)
                .doSelectPage(() -> subjectPoolMapper.listSubject(dto));
        final AtomicInteger index = new AtomicInteger((dto.getPage() - 1) * dto.getSize());
        List<SubjectPoolResultVO> list = data.getResult().stream().map(r -> entityToVO(index, r)).collect(Collectors.toList());
        return PageData.page(dto.getPage(), dto.getSize(), data.getTotal(), list);
    }

    @Override
    public Integer deleteEntity(String subjectId) {
        SubjectPoolEntity entity = new SubjectPoolEntity()
                .setState(1);
        Wrapper<SubjectPoolEntity> wrapper = new UpdateWrapper<>(new SubjectPoolEntity().setSubjectId(subjectId));
        return subjectPoolMapper.update(entity, wrapper);
    }

    @Override
    public Integer editEntity(SubjectPoolDTO dto) {
        List<String> subjectIds = dto.getSubjectIds();
        if (CollectionUtils.isNotEmpty(subjectIds)) {
            Wrapper<SubjectPoolEntity> wrapper = new QueryWrapper<>(new SubjectPoolEntity()).in("subject_id", subjectIds);
            final List<SubjectPoolEntity> subjectPoolEntities = subjectPoolMapper.selectList(wrapper)
                    .stream()
                    .filter(r -> Objects.isNull(r.getSubjectType()) && StringUtils.isEmpty(r.getChapterId()) && StringUtils.isEmpty(r.getFirstLevelId()) && StringUtils.isEmpty(r.getSecondLevelId()))
                    .collect(Collectors.toList());
            subjectPoolEntities.forEach(r -> {
                SubjectPoolEntity entity = new SubjectPoolEntity();
                BeanUtils.copyProperties(dto, entity);
                Wrapper<SubjectPoolEntity> updateWrapper = new UpdateWrapper<>(new SubjectPoolEntity().setSubjectId(dto.getSubjectId()));
                subjectPoolMapper.update(entity.setSubjectId(null), updateWrapper);
            });
            return subjectPoolEntities.size();
        }
        log.error("非法参数异常");
        throw new ServiceException("非法参数异常");
    }

    @Override
    public List<SubjectPoolEntity> listSubject(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            log.error("非法参数异常");
            throw new ServiceException("非法参数异常");
        }
        Wrapper<SubjectPoolEntity> wrapper = new QueryWrapper<>(new SubjectPoolEntity()).in("subject_id", ids);
        return subjectPoolMapper.selectList(wrapper);
    }

    @Override
    public List<SubjectPoolResultVO> listSubjectVO(List<String> ids) {
        final List<SubjectPoolEntity> entities = this.listSubject(ids);
        if (CollectionUtils.isEmpty(entities)) {
            log.error("非法参数异常");
            throw new ServiceException("非法参数异常");
        }
        final AtomicInteger index = new AtomicInteger(0);
        return entities.stream().map(r -> entityToVO(index, r)).collect(Collectors.toList());
    }

    /**
     * javadoc entityToVO
     * @apiNote entity 转为 VO
     *
     * @param index no
     * @param entity source
     * @return com.virgo.hw.bean.vo.SubjectPoolResultVO
     * @author wang chenkai
     * @date 2020/7/23  11:50 上午
     * @modified none
     */
    private SubjectPoolResultVO entityToVO(AtomicInteger index, SubjectPoolEntity entity) {
        SubjectPoolResultVO vo = new SubjectPoolResultVO();
        BeanUtils.copyProperties(entity, vo);
        if (Objects.nonNull(entity.getSubjectType())) {
            vo.setSubjectType(Pair.of(entity.getSubjectType(), SubjectTypeEnum.getEnum(entity.getSubjectType()).getMsg()));
        }
        return vo.setNo(index.incrementAndGet());
    }
}
