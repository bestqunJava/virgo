package com.virgo.hw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virgo.hw.bean.entity.PaperSubjectRelationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:46 下午
 */
@Repository
@Mapper
public interface PaperSubjectRelationMapper extends BaseMapper<PaperSubjectRelationEntity> {
}
