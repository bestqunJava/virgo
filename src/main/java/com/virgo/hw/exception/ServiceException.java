package com.virgo.hw.exception;


import com.virgo.hw.bean.enums.RespType;

/**
 * javadoc 业务异常处理器
 *
 * @author wang chenkai
 * @date 2020/3/6 10:44
 * @version 1.0.0
 */
public class ServiceException extends RuntimeException {

    private int code;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
        this.code = -1;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(RespType respType) {
        super(respType.getMessage());
        this.code = respType.getCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() {
        return code;
    }
}