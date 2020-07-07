package com.virgo.hw.ctrl;

import com.virgo.hw.bean.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchenkai
 * @since 2020/7/7 9:38 上午
 */
@RestController
@RequestMapping("virgo/")
public class SubjectPoolCtrl {

    @PostMapping("subject/pool/create")
    public Integer getTransactionRecord(@RequestBody UserDTO dto) {
        return 99;
    }
}
