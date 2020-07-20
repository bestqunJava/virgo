package com.virgo.hw.ctrl;

import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.dto.PaperDTO;
import com.virgo.hw.bean.dto.PaperQueryDTO;
import com.virgo.hw.bean.dto.PaperResultDTO;
import com.virgo.hw.bean.dto.PaperSubjectDTO;
import com.virgo.hw.service.IPaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangchenkai
 * @since 2020/7/10 10:18 上午
 */
@RestController
@RequestMapping("virgo/")
@Slf4j
public class PaperCtrl {

    @Resource
    IPaperService paperService;

    @PostMapping("paper/insert")
    public Integer insert(@RequestBody PaperDTO dto) {
        return paperService.insertEntity(dto);
    }

    @PostMapping("paper/list")
    public PageData<PaperResultDTO> list(@RequestBody PaperQueryDTO dto) {
        return paperService.list(dto);
    }

    @GetMapping("paper/subjects")
    public PaperSubjectDTO subjects(@RequestParam("id") Integer id) {
        return paperService.subjects(id);
    }
}
