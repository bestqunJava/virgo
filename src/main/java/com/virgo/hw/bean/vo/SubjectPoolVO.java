package com.virgo.hw.bean.vo;

import com.virgo.hw.bean.commom.Pair;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:07 下午
 */
@Data
@Accessors(chain = true)
public class SubjectPoolVO {

    private String subjectId;

    private Pair<Integer, String> subjectType;

    private Pair<String, String> chapter;

    private Pair<String, String> firstLevel;

    private Pair<String, String> secondLevel;

    private String subjectContent;

    private String referenceContent;

    private String analysisContent;

    private Integer subjectDegree;

    private Pair<Integer, String> past;

}
