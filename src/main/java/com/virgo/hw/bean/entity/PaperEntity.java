package com.virgo.hw.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:39 下午
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("paper")
public class PaperEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String paperName;

    private String sortArray;

    private LocalDateTime beginTime;

    private LocalDateTime createTime;

}
