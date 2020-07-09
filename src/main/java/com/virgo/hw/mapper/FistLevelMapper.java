package com.virgo.hw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virgo.hw.bean.entity.FistLevelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:24 上午
 */
@Repository
@Mapper
public interface FistLevelMapper extends BaseMapper<FistLevelEntity> {

}
