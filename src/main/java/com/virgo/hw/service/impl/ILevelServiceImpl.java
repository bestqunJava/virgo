package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevel;
import com.virgo.hw.mapper.FistLevelMapper;
import com.virgo.hw.mapper.SecondLevelMapper;
import com.virgo.hw.service.ILevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
                .setChapterId(firstLevelId)));
    }

    @Override
    public SecondLevel findSecondLevel(String secondLevelId) {
        return secondLevelMapper.selectOne(new QueryWrapper<>(new SecondLevel()
                .setChapterId(secondLevelId)));
    }
}
