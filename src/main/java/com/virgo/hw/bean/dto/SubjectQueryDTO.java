package com.virgo.hw.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/9 5:28 下午
 */
@Data
@Accessors(chain = true)
public class SubjectQueryDTO {

    /**
     * 分页索引
     **/
    private Integer page;

    /**
     * 也元素大小
     **/
    private Integer size;

    /**
     * 章节ID
     */
    private String chapterId;

    /**
     * 一级标题ID
     */
    private String firstLevelId;

    /**
     * 二级标题ID
     */
    private String secondLevelId;

    /**
     * 试题类型
     */
    private Integer subjectType;

    /**
     * 真题
     */
    private Integer past;

    /**
     * 试题难度
     */
    private Integer subjectDegree;

    /**
     * 试题来源
     */
    private Integer source;

    /**
     * 相似题编号
     */
    private String subjectId;

    /**
     * 试题ids
     */
    private List<String> subjectIds;

    /**
     * 试题内容
     */
    private Integer subjectContent;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
