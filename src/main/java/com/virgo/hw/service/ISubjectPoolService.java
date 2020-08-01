package com.virgo.hw.service;

import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.bean.dto.SubjectQueryDTO;
import com.virgo.hw.bean.entity.SubjectPoolEntity;
import com.virgo.hw.bean.vo.SubjectPoolResultVO;
import com.virgo.hw.bean.vo.SubjectPoolVO;

import java.io.InputStream;
import java.util.List;

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
     * @param dto dto
     * @return com.virgo.hw.bean.vo.SubjectPoolVO
     * @author wang chenkai
     * @date 2020/7/9  4:45 下午
     * @modified none
     */
    List<SubjectPoolVO> findEntity(SubjectQueryDTO dto);

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

    /**
     * javadoc deleteEntity
     * @apiNote 删除试题
     *
     * @param subjectId subjectId
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/9  6:55 下午
     * @modified none
     */
    Integer deleteEntity(String subjectId);

    /**
     * javadoc editEntity
     * @apiNote 编辑试题
     *
     * @param dto dto
     * @return java.lang.Integer
     * @author wang chenkai
     * @date 2020/7/10  10:00 上午
     * @modified none
     */
    Integer editEntity(SubjectPoolDTO dto);

    /**
     * javadoc listSubject
     * @apiNote 通过试题IDs获取试题列表
     *
     * @param ids ids
     * @return java.util.List<com.virgo.hw.bean.vo.SubjectPoolResultVO>
     * @author wang chenkai
     * @date 2020/7/20  5:04 下午
     * @modified none
     */
    List<SubjectPoolEntity> listSubject(List<String> ids);

    /**
     * javadoc listSubjectVO
     * @apiNote 包裹list
     *
     * @param ids entities
     * @return java.util.List<com.virgo.hw.bean.vo.SubjectPoolResultVO>
     * @author wang chenkai
     * @date 2020/7/23  11:44 上午
     * @modified none
     */
    List<SubjectPoolResultVO> listSubjectVO(List<String> ids);

}
