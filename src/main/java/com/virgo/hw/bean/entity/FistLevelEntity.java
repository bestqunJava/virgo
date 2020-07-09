package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/7/9 4:26 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("fist_level")
public class FistLevelEntity {

    private String id;

    private String firstLevelId;

    private String chapterId;

    private String firstLevelName;

    private LocalDateTime createTime;
}
