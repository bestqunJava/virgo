package com.virgo.hw.ctrl;

import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.entity.FistLevelEntity;
import com.virgo.hw.bean.entity.SecondLevelEntity;
import com.virgo.hw.service.ILevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public List<Pair<String, String>> listFirstLevel(@RequestParam("chapterId") String chapterId) {
        return levelService.listFirstLevel(chapterId);
    }

    @GetMapping("level/second/list")
    public List<Pair<String, String>> listSecondLevel(@RequestParam("firstLevelId") String firstLevelId) {
        return levelService.listSecondLevel(firstLevelId);
    }

    @PostMapping("level/second/insert")
    public Integer secondLevelInsert(@RequestBody SecondLevelEntity entity) {
        return levelService.secondLevelInsert(entity);
    }

    @PostMapping("level/first/insert")
    public Integer firstLevelInsert(@RequestBody FistLevelEntity entity) {
        return levelService.firstLevelInsert(entity);
    }
}
