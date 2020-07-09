package com.virgo.hw.service;

import com.virgo.hw.bean.entity.ChapterEntity;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:20 上午
 */
public interface IChapterService {

    /**
     * javadoc findEntry
     * @apiNote find by id
     *
     * @param chapterId 章节id
     * @return com.virgo.hw.bean.entity.ChapterEntity
     * @author wang chenkai
     * @date 2020/7/9  3:11 下午
     * @modified none
     */
    ChapterEntity findEntry(String chapterId);

}
