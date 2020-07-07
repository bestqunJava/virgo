package com.virgo.hw.feign;

import com.virgo.hw.bean.dto.CollectPhotoDTO;
import com.virgo.hw.bean.dto.YouDaoResponse;
import com.virgo.hw.bean.dto.CollectPhotoResult;
import com.virgo.hw.util.FeignSimpleEncoderConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:24 上午
 */
@FeignClient(name = "youDaoApi", qualifier = "youDaoApiClient",
        url = "https://openapi.youdao.com", configuration = FeignSimpleEncoderConfig.class)
public interface YouDaoApiClient {

    /**
     * javadoc photoCollect
     * @apiNote 拍照收集题
     *
     * @param dto dto
     * @return com.virgo.hw.bean.dto.CollectPhotoResponse<com.virgo.hw.bean.dto.CollectPhotoResult>
     * @author wang chenkai
     * @date 2020/7/7  3:01 下午
     * @modified none
     */
    @PostMapping(value = "/ocrquestionapi",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    YouDaoResponse<CollectPhotoResult> photoCollect(CollectPhotoDTO dto);
}
