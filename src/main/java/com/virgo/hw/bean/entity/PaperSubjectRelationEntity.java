package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:42 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("paper_subject_relation")
public class PaperSubjectRelationEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer paperId;

    private String subjectId;
}
