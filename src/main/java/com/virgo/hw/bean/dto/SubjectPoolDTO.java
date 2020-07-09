package com.virgo.hw.bean.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:07 下午
 */
@Data
@Accessors(chain = true)
public class SubjectPoolDTO {

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

}
