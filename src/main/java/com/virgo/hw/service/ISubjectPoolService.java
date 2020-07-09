package com.virgo.hw.service;

import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.bean.dto.SubjectQueryDTO;
import com.virgo.hw.bean.vo.SubjectPoolResultVO;
import com.virgo.hw.bean.vo.SubjectPoolVO;

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
    String insertEntity(SubjectPoolDTO dto);

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
    String photoCollect(InputStream inputStream);

    /**
     * javadoc findEntity
     * @apiNote 详情
     *
     * @param subjectId subjectId
     * @return com.virgo.hw.bean.vo.SubjectPoolVO
     * @author wang chenkai
     * @date 2020/7/9  4:45 下午
     * @modified none
     */
    SubjectPoolVO findEntity(String subjectId);

    /**
     * javadoc listSubject
     * @apiNote 试题管理列表
     *
     * @param dto dto
     * @return com.virgo.hw.bean.commom.PageData<com.virgo.hw.bean.vo.SubjectPoolVO>
     * @author wang chenkai
     * @date 2020/7/9  5:32 下午
     * @modified none
     */
    PageData<SubjectPoolResultVO> listSubject(SubjectQueryDTO dto);

}
