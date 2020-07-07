package com.virgo.hw.bean.dto;

import lombok.Data;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:59 下午
 */
@Data
public class Question {
    private String answer;
    private String id;
    private String analysis;
    private String content;
    private String knowledge;
}
