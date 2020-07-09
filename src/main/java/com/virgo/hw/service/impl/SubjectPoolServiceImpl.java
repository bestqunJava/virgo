package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.dto.*;
import com.virgo.hw.bean.entity.ChapterEntity;
import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevel;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.bean.enums.SnowflakeIdWorker;
import com.virgo.hw.bean.enums.SubjectTypeEnum;
import com.virgo.hw.bean.vo.SubjectPoolVO;
import com.virgo.hw.feign.YouDaoApiClient;
import com.virgo.hw.mapper.SubjectPoolMapper;
import com.virgo.hw.service.IChapterService;
import com.virgo.hw.service.ILevelService;
import com.virgo.hw.service.ISubjectPoolService;
import com.virgo.hw.util.YouDaoSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

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

    @Resource
    IChapterService chapterService;

    @Resource
    ILevelService levelService;

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
            throw new RuntimeException("搜题服务异常...", e);
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
        throw new RuntimeException("添加试题异常");
    }

    @Override
    public SubjectPoolVO findEntity(String subjectId) {
        SubjectPoolEntity entity = subjectPoolMapper.selectOne(new QueryWrapper<>(new SubjectPoolEntity()
                .setSubjectId(subjectId)));
        return Optional.ofNullable(entity).map(r -> {
            SubjectPoolVO vo = new SubjectPoolVO();
            BeanUtils.copyProperties(r, vo);
            if (Objects.nonNull(r.getSubjectType())) {
                vo.setSubjectType(Pair.of(r.getSubjectType(), SubjectTypeEnum.getEnum(r.getSubjectType()).getMsg()));
            }
            if (Objects.nonNull(r.getChapterId())) {
                ChapterEntity entry = chapterService.findEntry(r.getChapterId());
                Optional.ofNullable(entry).ifPresent(obj -> vo.setChapter(Pair.of(r.getChapterId(), obj.getChapterName())));
            }
            if (Objects.nonNull(r.getFirstLevelId())) {
                FistLevelEntity entry = levelService.findFirstLevel(r.getFirstLevelId());
                Optional.ofNullable(entry).ifPresent(obj -> vo.setFirstLevel(Pair.of(r.getFirstLevelId(), entry.getFirstLevelName())));
            }
            if (Objects.nonNull(r.getSecondLevelId())) {
                SecondLevel entry = levelService.findSecondLevel(r.getSecondLevelId());
                Optional.ofNullable(entry).ifPresent(obj ->
                        vo.setSecondLevel(Pair.of(r.getSecondLevelId(), entry.getSecondLevelName())));
            }
            return vo;
        }).orElse(null);
    }
}
