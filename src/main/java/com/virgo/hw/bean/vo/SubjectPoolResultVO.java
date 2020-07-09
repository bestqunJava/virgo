package com.virgo.hw.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.virgo.hw.bean.commom.Pair;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:07 下午
 */
@Data
@Accessors(chain = true)
public class SubjectPoolResultVO {

    private Integer no;

    private String subjectId;

    private Pair<Integer, String> subjectType;

    private String subjectContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private Integer subjectDegree;

    private Integer past;

}
