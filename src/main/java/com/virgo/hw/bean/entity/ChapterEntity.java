package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/7/9 3:05 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("chapter")
public class ChapterEntity {

    private String id;

    private String chapterId;

    private String chapterName;

    private String createTime;
}
