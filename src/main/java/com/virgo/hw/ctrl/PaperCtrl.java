package com.virgo.hw.ctrl;

import com.virgo.hw.bean.dto.PaperDTO;
import com.virgo.hw.service.IPaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
