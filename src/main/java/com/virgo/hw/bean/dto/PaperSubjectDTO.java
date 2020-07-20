package com.virgo.hw.bean.dto;

import com.virgo.hw.bean.entity.SubjectPoolEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:57 下午
 */
@Data
@Accessors(chain = true)
public class PaperSubjectDTO {

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 排序数组字符串
     */
    private String sortArray;

    /**
     * 试题集合
     */
   private Map<Integer, List<SubjectPoolEntity>> subjects;

}
