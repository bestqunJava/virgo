package com.virgo.hw.ctrl;

import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.service.ISubjectPoolService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangchenkai
 * @since 2020/7/7 9:38 上午
 */
@RestController
@RequestMapping("virgo/")
public class SubjectPoolCtrl {

    @Resource
    ISubjectPoolService subjectPoolService;

    @PostMapping("subject/pool/create")
    public Integer getTransactionRecord(@RequestBody SubjectPoolDTO dto) {
        return subjectPoolService.insertEntity(dto);
    }
}
