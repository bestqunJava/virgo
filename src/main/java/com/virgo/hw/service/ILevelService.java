package com.virgo.hw.service;

import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevel;

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
    SecondLevel findSecondLevel(String secondLevelId);

}
