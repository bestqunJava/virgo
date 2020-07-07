package com.virgo.hw.service;

import com.virgo.hw.bean.dto.SubjectPoolDTO;

/**
 * @author wangchenkai
 * @since 2020/7/7 10:20 上午
 */
public interface ISubjectPoolService {

    /**
     * javadoc createEntity
     * @apiNote 题库添加试题
     *
     * @param dto dto
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/7  11:08 上午
     * @modified none
     */
    Integer insertEntity(SubjectPoolDTO dto);
}
