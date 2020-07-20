package com.virgo.hw.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:57 下午
 */
@Data
@Accessors(chain = true)
public class PaperResultDTO {

    /**
     * 序号
     */
    private Integer no;

    /**
     * 试卷ID
     */
    private Integer id;

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 排序数组字符串
     */
    private String sortArray;

    /**
     * 开始考试时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
