package com.virgo.hw.bean.dto;

import lombok.Data;

import java.util.Objects;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:53 下午
 */
@Data
public class YouDaoResponse<T> {

    private String errorCode;

    private T data;

    public static <T> boolean ok(YouDaoResponse<T> resp) {
        return Objects.nonNull(resp) && "0".equals(resp.getErrorCode());
    }

}
