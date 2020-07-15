package com.virgo.hw.service;

import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevelEntity;

import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:20 上午
 */
public interface ILevelService {

    /**
     * javadoc findFirstLevel
     * @apiNote 获取一级知识点信息
     *
     * @param firstLevelId firstLevelId
     * @return com.virgo.hw.bean.entity.FistLevelEntity
     * @author wang chenkai
     * @date 2020/7/9  4:39 下午
     * @modified none
     */
    FistLevelEntity findFirstLevel(String firstLevelId);

    /**
     * javadoc secondFirstLevel
     * @apiNote 获取二级知识点信息
     *
     * @param secondLevelId secondLevelId
     * @return com.virgo.hw.bean.entity.SecondLevel
     * @author wang chenkai
     * @date 2020/7/9  4:40 下午
     * @modified none
     */
    SecondLevelEntity findSecondLevel(String secondLevelId);

    /**
     * javadoc listFirstLevel
     * @apiNote 一级知识点列表
     *
     * @param chapterId chapterId
     * @return java.util.List<com.virgo.hw.bean.commom.Pair<java.lang.String,java.lang.String>>
     * @author wang chenkai
     * @date 2020/7/10  11:58 上午
     * @modified none
     */
    List<Pair<String, String>> listFirstLevel(String chapterId);

    /**
     * javadoc listSecondLevel
     * @apiNote 二级知识点列表
     *
     * @param firstLevelId firstLevelId
     * @return java.util.List<com.virgo.hw.bean.commom.Pair<java.lang.String,java.lang.String>>
     * @author wang chenkai
     * @date 2020/7/10  11:58 上午
     * @modified none
     */
    List<Pair<String, String>> listSecondLevel(String firstLevelId);

    /**
     * javadoc firstLevelInsert
     * @apiNote insert
     *
     * @param entity entity
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/15  2:23 下午
     * @modified none
     */
    Integer firstLevelInsert(FistLevelEntity entity);

    /**
     * javadoc secondLevelInsert
     * @apiNote insert
     *
     * @param entity entity
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/15  2:23 下午
     * @modified none
     */
    Integer secondLevelInsert(SecondLevelEntity entity);

}
