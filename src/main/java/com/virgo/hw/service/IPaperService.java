package com.virgo.hw.service;

import com.virgo.hw.bean.dto.PaperDTO;

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
}
