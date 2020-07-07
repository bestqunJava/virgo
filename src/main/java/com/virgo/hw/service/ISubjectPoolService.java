package com.virgo.hw.service;

import com.virgo.hw.bean.dto.CollectPhotoDTO;
import com.virgo.hw.bean.dto.CollectPhotoResult;
import com.virgo.hw.bean.dto.SubjectPoolDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.InputStream;

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

    /**
     * javadoc photoCollect
     * @apiNote 拍照收集题
     *
     * @param inputStream 输入流
     * @return com.virgo.hw.bean.dto.CollectPhotoResult
     * @author wang chenkai
     * @date 2020/7/7  3:15 下午
     * @modified none
     */
    CollectPhotoResult photoCollect(InputStream inputStream);



}
