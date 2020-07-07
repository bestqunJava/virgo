package com.virgo.hw.util;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchenkai
 * @since 2020/7/7 4:37 下午
 */
@Configuration
public class FeignSimpleEncoderConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Encoder encoder(){
        return new FormEncoder();
    }
}
