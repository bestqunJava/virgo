package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:07 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("subject_pool")
public class SubjectPoolEntity {

    @TableField(exist = false)
    private Integer id;

    private String subjectId;

    private Integer subjectType;

    private String chapterId;

    private String firstLevelId;

    private String secondLevelId;

    private String subjectContent;

    private String referenceContent;

    private String analysisContent;

    private Integer subjectDegree;

    private Integer past;

    private Integer source;

    private LocalDateTime createTime;

}
