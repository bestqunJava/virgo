package com.virgo.hw.ctrl;

import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.service.ILevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangchenkai
 * @since 2020/7/10 10:18 上午
 */
@RestController
@RequestMapping("virgo/")
@Slf4j
public class LevelCtrl {

    @Resource
    ILevelService levelService;

    @GetMapping("level/first/list")
    public List<Pair<String, String>> listFirstLevel() {
        return levelService.listFirstLevel();
    }

    @GetMapping("level/second/list")
    public List<Pair<String, String>> listSecondLevel() {
        return levelService.listSecondLevel();
    }
}
