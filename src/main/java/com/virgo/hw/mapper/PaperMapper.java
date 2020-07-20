package com.virgo.hw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virgo.hw.bean.dto.PaperQueryDTO;
import com.virgo.hw.bean.entity.PaperEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:46 下午
 */
@Repository
@Mapper
public interface PaperMapper extends BaseMapper<PaperEntity> {

    /**
     * javadoc listPapers
     * @apiNote 试卷列表
     *
     * @param dto dto
     * @return java.util.List<com.virgo.hw.bean.entity.PaperEntity>
     * @author wang chenkai
     * @date 2020/7/20  4:43 下午
     * @modified none
     */
    List<PaperEntity> listPapers(PaperQueryDTO dto);
}
