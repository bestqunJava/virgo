package com.virgo.hw.service;

import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.dto.PaperDTO;
import com.virgo.hw.bean.dto.PaperQueryDTO;
import com.virgo.hw.bean.dto.PaperResultDTO;

import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/20 2:53 下午
 */
public interface IPaperService {

   /**
    * javadoc insertEntity
    * @apiNote 添减试卷
    *
    * @param dto dto
    * @return java.lang.Integer
    * @author wang chenkai
    * @date 2020/7/20  2:58 下午
    * @modified none
    */
   Integer insertEntity(PaperDTO dto);

   /**
    * javadoc list
    * @apiNote 试卷管理
    *
    * @param dto dto
    * @return java.util.List<com.virgo.hw.bean.dto.PaperResultDTO>
    * @author wang chenkai
    * @date 2020/7/20  4:35 下午
    * @modified none
    */
   PageData<PaperResultDTO> list(PaperQueryDTO dto);
}
