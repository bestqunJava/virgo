package com.virgo.hw.service.impl;

import com.virgo.hw.bean.dto.PaperDTO;
import com.virgo.hw.bean.entity.PaperEntity;
import com.virgo.hw.bean.entity.PaperSubjectRelationEntity;
import com.virgo.hw.exception.ServiceException;
import com.virgo.hw.mapper.PaperMapper;
import com.virgo.hw.mapper.PaperSubjectRelationMapper;
import com.virgo.hw.service.IPaperService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:21 上午
 */
@Service
@Slf4j
public class PaperServiceImpl implements IPaperService {

    @Resource
    PaperMapper paperMapper;

    @Resource
    PaperSubjectRelationMapper paperSubjectRelationMapper;

    @Override
    public Integer insertEntity(PaperDTO dto) {
        PaperEntity paper = new PaperEntity();
        BeanUtils.copyProperties(dto, paper);
        int insert = paperMapper.insert(paper);
        List<PaperSubjectRelationEntity> paperSubjectRelationEntities = dto.getSubjectIds().stream().map(p -> {
            PaperSubjectRelationEntity relationEntity = new PaperSubjectRelationEntity();
            return relationEntity.setPaperId(paper.getId()).setSubjectId(p);
        }).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(paperSubjectRelationEntities)) {
            paperSubjectRelationEntities.forEach(r -> paperSubjectRelationMapper.insert(r));
            return insert;
        }
        throw new ServiceException("添加试卷异常");
    }
}
