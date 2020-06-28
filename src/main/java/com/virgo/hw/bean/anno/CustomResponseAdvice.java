package com.virgo.hw.bean.anno;

import java.lang.annotation.*;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:41 下午
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomResponseAdvice {
}
