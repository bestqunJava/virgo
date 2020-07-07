package com.virgo.hw.service.impl;

import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.bean.enums.SnowflakeIdWorker;
import com.virgo.hw.mapper.SubjectPoolMapper;
import com.virgo.hw.service.ISubjectPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:21 上午
 */
@Service
@Slf4j
public class SubjectPoolServiceImpl implements ISubjectPoolService {

    @Resource
    SubjectPoolMapper subjectPoolMapper;

    @Override
    public Integer insertEntity(SubjectPoolDTO dto) {
        SubjectPoolEntity entity = new SubjectPoolEntity();
        BeanUtils.copyProperties(dto, entity);
        return subjectPoolMapper.insert(entity.setSubjectId(SnowflakeIdWorker.takeIdString())
                .setCreateTime(LocalDateTime.now())
        );
    }
}
