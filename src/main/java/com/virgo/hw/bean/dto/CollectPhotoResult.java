package com.virgo.hw.bean.dto;

import lombok.Data;

import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/7 2:53 下午
 */
@Data
public class CollectPhotoResult {

    private List<Question> questions;

    private String text;

}
