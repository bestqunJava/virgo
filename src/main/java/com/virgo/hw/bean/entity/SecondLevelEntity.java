package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/7/9 4:28 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("second_level")
public class SecondLevelEntity {

    private String id;

    private String secondLevelId;

    private String firstLevelId;

    private String chapterId;

    private String secondLevelName;

    private LocalDateTime createTime;

}
