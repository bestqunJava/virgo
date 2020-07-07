package com.virgo.hw.bean.entity;

import lombok.Data;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:07 下午
 */
@Data
public class SubjectPoolEntity {

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

    private String createTime;

}
