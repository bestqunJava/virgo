package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.dto.PaperDTO;
import com.virgo.hw.bean.dto.PaperQueryDTO;
import com.virgo.hw.bean.dto.PaperResultDTO;
import com.virgo.hw.bean.dto.PaperSubjectDTO;
import com.virgo.hw.bean.entity.PaperEntity;
import com.virgo.hw.bean.entity.PaperSubjectRelationEntity;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.exception.ServiceException;
import com.virgo.hw.mapper.PaperMapper;
import com.virgo.hw.mapper.PaperSubjectRelationMapper;
import com.virgo.hw.service.IPaperService;
import com.virgo.hw.service.ISubjectPoolService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
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

    @Resource
    ISubjectPoolService subjectPoolService;

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

    @Override
    public PageData<PaperResultDTO> list(PaperQueryDTO dto) {
        final Page<PaperEntity> data = PageHelper.startPage(dto.getPage(), dto.getSize(), true)
                .doSelectPage(() -> paperMapper.listPapers(dto));
        final AtomicInteger index = new AtomicInteger((dto.getPage() - 1) * dto.getSize());
        List<PaperResultDTO> list = data.getResult().stream().map(r -> {
            PaperResultDTO vo = new PaperResultDTO();
            BeanUtils.copyProperties(r, vo);
            return vo.setNo(index.incrementAndGet());
        }).collect(Collectors.toList());
        return PageData.page(dto.getPage(), dto.getSize(), data.getTotal(), list);
    }

    @Override
    public PaperSubjectDTO subjects(Integer id) {
        PaperEntity paperEntity = paperMapper.selectById(id);
        PaperSubjectDTO result = new PaperSubjectDTO();
        if (Objects.nonNull(paperEntity)) {
            result.setPaperName(paperEntity.getPaperName()).setSortArray(paperEntity.getSortArray());
        }
        Wrapper<PaperSubjectRelationEntity> wrapper = new QueryWrapper<>(new PaperSubjectRelationEntity().setPaperId(id));
        List<String> subjectIds = paperSubjectRelationMapper
                .selectList(wrapper)
                .stream()
                .map(PaperSubjectRelationEntity::getSubjectId)
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(subjectIds)) {
            Map<Integer, List<SubjectPoolEntity>> collect = subjectPoolService.listSubject(subjectIds)
                    .stream()
                    .filter(r -> Objects.nonNull(r.getSubjectType()))
                    .collect(Collectors.groupingBy(SubjectPoolEntity::getSubjectType));
            result.setSubjects(collect);
        }
        return result;
    }
}
