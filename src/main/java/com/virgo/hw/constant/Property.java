package com.virgo.hw.constant;

import com.virgo.hw.bean.commom.Result;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * javadoc 常量属性
 *
 * @author wang chenkai
 * @date 2020/3/6 10:44
 * @version 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Property {
    public static final String SHADOW_TOKEN = "SHADOW_TOKEN";

    public static final Result OK = new Result(0, "success", null);

    public static final Result ERROR = new Result(-1, "error", null);

    public static final Result LOGIN_ERROR = new Result(-1, "error", null);
}
