package com.virgo.hw.service.impl;

import com.virgo.hw.bean.dto.CollectPhotoDTO;
import com.virgo.hw.bean.dto.CollectPhotoResult;
import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.bean.dto.YouDaoResponse;
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

    @Override
    public Integer insertEntity(SubjectPoolDTO dto) {
        SubjectPoolEntity entity = new SubjectPoolEntity();
        BeanUtils.copyProperties(dto, entity);
        return subjectPoolMapper.insert(entity.setSubjectId(SnowflakeIdWorker.takeIdString())
                .setCreateTime(LocalDateTime.now())
        );
    }

    @Override
    public CollectPhotoResult photoCollect(InputStream picPath) {
        String path = YouDaoSignUtil.loadAsBase64(picPath);
        String salt = String.valueOf(System.currentTimeMillis());
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        String question = APP_KEY + YouDaoSignUtil.truncate(path) + salt + curTime + APP_SECRET;
        YouDaoResponse<CollectPhotoResult> resp = youDaoApiClient.photoCollect(new CollectPhotoDTO()
                .setAppKey(APP_KEY)
                .setCurtime(curTime)
                .setQ(path)
                .setSalt(salt)
                .setType(TYPE)
                .setSignType(SIGN_TYPE)
                .setSign(YouDaoSignUtil.getDigest(question))
                .setSearchType("img")
        );
        if (YouDaoResponse.ok(resp)) {
            return resp.getData();
        }
        log.error("有道云拍照搜题服务失败");
        throw new RuntimeException("有道云拍照搜题服务失败");
    }
}
