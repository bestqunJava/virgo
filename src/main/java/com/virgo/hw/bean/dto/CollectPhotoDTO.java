package com.virgo.hw.bean.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:46 下午
 */
@Data
@Accessors(chain = true)
public class CollectPhotoDTO {

    private String q;

    private String appKey;

    private String salt;

    private String curtime;

    private String sign;

    private String signType;

    private String type;

    private String searchType;

}
