package com.virgo.hw.bean.commom;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * javadoc http接口返回的逻辑处理状态和逻辑处理消息包裹类,平台某些服务使用此格式, app接口使用此格式
 *
 * @author wang chenkai
 * @date 2020/2/12 20:54
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Result {

    private Integer code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errorMessages;
}
