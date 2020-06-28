package com.virgo.hw.ctrl;

import com.virgo.hw.bean.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchenkai
 * @since 2020/6/28 4:46 下午
 */
@RestController
@RequestMapping("virgo/outer/")
public class UserCtrl {

    @PostMapping("login")
    public Integer getTransactionRecord(@RequestBody UserDTO dto){
        return 99;
    }
}
