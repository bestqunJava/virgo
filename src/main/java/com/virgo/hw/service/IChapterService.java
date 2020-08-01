package com.virgo.hw.service;

import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.entity.ChapterEntity;

import java.util.List;

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

    /**
     * javadoc listChapter
     * @apiNote 所有章节
     *
     * @return java.util.List<com.virgo.hw.bean.commom.Pair<java.lang.String,java.lang.String>>
     * @author wang chenkai
     * @date 2020/7/10  10:20 上午
     * @modified none
     */
    List<Pair<String, String>> listChapter();

    /**
     * javadoc insertEntity
     * @apiNote 添加章节
     *
     * @param entity entity
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/15  2:14 下午
     * @modified none
     */
    Integer insertEntity(ChapterEntity entity);

    /**
     * javadoc deleteEntity
     * @apiNote 删除
     *
     * @param chapterId 章节id
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/8/1  12:20 下午
     * @modified none
     */
    Integer deleteEntity(String chapterId);

}
