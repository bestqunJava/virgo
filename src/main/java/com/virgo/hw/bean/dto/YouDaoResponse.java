package com.virgo.hw.bean.dto;

import lombok.Data;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:53 下午
 */
@Data
public class YouDaoResponse<T> {

    private String errorCode;

    private T data;

}
