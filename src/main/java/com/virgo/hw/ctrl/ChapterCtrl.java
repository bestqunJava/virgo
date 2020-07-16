package com.virgo.hw.ctrl;

import com.virgo.hw.bean.anno.CustomResponseAdvice;
import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.commom.Resp;
import com.virgo.hw.bean.entity.ChapterEntity;
import com.virgo.hw.service.IChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class ChapterCtrl {

    @Resource
    IChapterService chapterService;

    @GetMapping("chapters")
    public List<Pair<String, String>> subject() {
        return chapterService.listChapter();
    }

    @GetMapping("chapter/insert")
    public Integer insert(@RequestParam("chapterName") String chapterName) {
        return chapterService.insertEntity(new ChapterEntity().setChapterName(chapterName));
    }

    @GetMapping("chapter/test")
    @CustomResponseAdvice
    public Resp<String> test() {
        return Resp.ok("test");
    }
}
