package com.virgo.hw.bean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:46 下午
 */
@Data
@Accessors(chain = true)
public class CollectPhotoDTO {

    @JsonProperty("q")
    private String question;

    private String appKey;

    private String salt;

    @JsonProperty("curtime")
    private String curTime;

    @JsonProperty("sign")
    private String sign;

    private String signType;

    private String type;

    private String searchType;

}
