package com.virgo.hw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.virgo.hw.bean.entity.ChapterEntity;
import com.virgo.hw.mapper.ChapterMapper;
import com.virgo.hw.service.IChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:21 上午
 */
@Service
@Slf4j
public class ChapterServiceImpl implements IChapterService {

    @Resource
    ChapterMapper chapterMapper;

    @Override
    public ChapterEntity findEntry(String chapterId) {
        return chapterMapper.selectOne(new QueryWrapper<>(new ChapterEntity()
                .setChapterId(chapterId)));
    }
}