package com.virgo.hw.service.impl;

import com.virgo.hw.bean.dto.*;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.bean.enums.SnowflakeIdWorker;
import com.virgo.hw.feign.YouDaoApiClient;
import com.virgo.hw.mapper.SubjectPoolMapper;
import com.virgo.hw.service.ISubjectPoolService;
import com.virgo.hw.util.YouDaoSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.time.LocalDateTime;
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
    public Integer insertEntity(SubjectPoolDTO dto) {
        SubjectPoolEntity entity = new SubjectPoolEntity();
        BeanUtils.copyProperties(dto, entity);
        return subjectPoolMapper.insert(entity.setSubjectId(SnowflakeIdWorker.takeIdString())
                .setCreateTime(LocalDateTime.now())
        );
    }

    @Override
    public Integer photoCollect(InputStream picPath) {
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
            }).orElse(0);
        }
        log.error("添加试题异常{}", resp);
        throw new RuntimeException("添加试题异常");
    }
}
