package com.virgo.hw.bean.commom;

/**
 * javadoc 返回值code message枚举类
 *
 * @author wang chenkai
 * @date 2019/12/11 15:14
 * @version 1.0.0
 */
public enum RespType {
    /**
     * 正常情况下的响应值
     **/
    OK(0, "success"),
    /**
     * 正常情况下错误响应值
     **/
    ERROR(-1, "error");

    private Integer code;

    private String message;

    RespType(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
