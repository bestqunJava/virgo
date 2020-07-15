package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevelEntity;
import com.virgo.hw.bean.enums.SnowflakeIdWorker;
import com.virgo.hw.mapper.FistLevelMapper;
import com.virgo.hw.mapper.SecondLevelMapper;
import com.virgo.hw.service.ILevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:20 上午
 */
@Service
@Slf4j
public class ILevelServiceImpl implements ILevelService {

    @Resource
    FistLevelMapper fistLevelMapper;

    @Resource
    SecondLevelMapper secondLevelMapper;


    @Override
    public FistLevelEntity findFirstLevel(String firstLevelId) {
        return fistLevelMapper.selectOne(new QueryWrapper<>(new FistLevelEntity()
                .setFirstLevelId(firstLevelId)));
    }

    @Override
    public SecondLevelEntity findSecondLevel(String secondLevelId) {
        return secondLevelMapper.selectOne(new QueryWrapper<>(new SecondLevelEntity()
                .setSecondLevelId(secondLevelId)));
    }

    @Override
    public List<Pair<String, String>> listFirstLevel(String chapterId) {
        Wrapper<FistLevelEntity> wrapper = new QueryWrapper<>(new FistLevelEntity().setChapterId(chapterId));
        return fistLevelMapper.selectList(wrapper).stream().map(r ->
                Pair.of(r.getFirstLevelId(), r.getFirstLevelName())).collect(Collectors.toList());
    }

    @Override
    public List<Pair<String, String>> listSecondLevel(String firstLevelId) {
        Wrapper<SecondLevelEntity> wrapper = new QueryWrapper<>(new SecondLevelEntity().setFirstLevelId(firstLevelId));
        return secondLevelMapper.selectList(wrapper).stream().map(r ->
                Pair.of(r.getSecondLevelId(), r.getSecondLevelName())).collect(Collectors.toList());
    }

    @Override
    public Integer firstLevelInsert(FistLevelEntity entity) {
        return fistLevelMapper.insert(entity.setCreateTime(LocalDateTime.now())
                .setFirstLevelId(SnowflakeIdWorker.takeIdStringRandom())
        );
    }

    @Override
    public Integer secondLevelInsert(SecondLevelEntity entity) {
        FistLevelEntity firstLevel = this.findFirstLevel(entity.getFirstLevelId());
        return secondLevelMapper.insert(entity.setCreateTime(LocalDateTime.now())
                .setSecondLevelId(SnowflakeIdWorker.takeIdStringRandom())
                .setChapterId(Objects.nonNull(firstLevel) ? firstLevel.getChapterId() : null)
        );
    }
}
