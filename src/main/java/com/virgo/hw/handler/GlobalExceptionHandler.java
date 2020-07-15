package com.virgo.hw.handler;

import com.virgo.hw.bean.commom.Resp;
import com.virgo.hw.bean.enums.RespType;
import com.virgo.hw.constant.Property;
import com.virgo.hw.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * javadoc 全局统一异常处理器
 *
 * @author wang chenkai
 * @date 2019-10-27 14:20
 * @version 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resp<String> handleRequestPathNotFound(NoHandlerFoundException ex){
        log.error(ExceptionUtils.getStackTrace(ex));
        return Resp.build(RespType.ERROR.getCode(), "request url path not found, no router handler match, exception: " + ex.getMessage(), null);
    }

    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resp<Object> handleException(ServiceException ex){
        log.error(ExceptionUtils.getStackTrace(ex));
        return Resp.buildWithResult(ex.getCode(), ex.getMessage(), null);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resp<Object> handleException(Exception ex){
        log.error(ExceptionUtils.getStackTrace(ex));
        return Resp.buildWithResult(Property.ERROR.getCode(), Property.ERROR.getMessage(), null);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resp<Object> handleException(RuntimeException ex){
        log.error(ExceptionUtils.getStackTrace(ex));
        return Resp.build(Property.ERROR.getCode(), ex.getMessage(), null);
    }
}
