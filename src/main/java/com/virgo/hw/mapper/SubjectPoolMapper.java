package com.virgo.hw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virgo.hw.bean.dto.SubjectQueryDTO;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:24 上午
 */
@Repository
@Mapper
public interface SubjectPoolMapper extends BaseMapper<SubjectPoolEntity> {

    /**
     * javadoc listSubject
     * @apiNote 试题管理列表
     * 
     * @param dto dto
     * @return java.util.List<com.virgo.hw.bean.entity.SubjectPoolEntity>
     * @author wang chenkai
     * @date 2020/7/9  5:37 下午
     * @modified none
     */
    List<SubjectPoolEntity> listSubject(SubjectQueryDTO dto);

}
