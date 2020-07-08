package com.virgo.hw.ctrl;

import com.virgo.hw.bean.commom.Pair;
import com.virgo.hw.bean.enums.SubjectTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangchenkai
 * @since 2020/7/7 9:38 上午
 */
@RestController
@RequestMapping("virgo/")
@Slf4j
public class CommonCtrl {

    @GetMapping("common/subject/types")
    public List<Pair<Integer, String>> getTransactionRecord() {
        return SubjectTypeEnum.SUBJECT_TYPE_ENUMS
                .stream()
                .map(r -> Pair.of(r.getCode(), r.getMsg()))
                .collect(Collectors.toList());
    }
}
