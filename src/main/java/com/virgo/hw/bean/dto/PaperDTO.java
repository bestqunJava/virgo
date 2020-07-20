package com.virgo.hw.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:57 下午
 */
@Data
@Accessors(chain = true)
public class PaperDTO {

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 排序数组字符串
     */
    private String sortArray;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    /**
     * 试题ids
     */
    private List<String>  subjectIds;
}
