package com.virgo.hw.ctrl;

import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.service.ISubjectPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author wangchenkai
 * @since 2020/7/7 9:38 上午
 */
@RestController
@RequestMapping("virgo/")
@Slf4j
public class SubjectPoolCtrl {

    @Resource
    ISubjectPoolService subjectPoolService;

    @PostMapping("subject/pool/create")
    public Integer getTransactionRecord(@RequestBody SubjectPoolDTO dto) {
        return subjectPoolService.insertEntity(dto);
    }

    @PostMapping("subject/pool/collect")
    public Integer photoCollect(@RequestParam("file") MultipartFile file) {
        try {
            return subjectPoolService.photoCollect(file.getInputStream());
        } catch (IOException e) {
            log.error("获取上传图片流异常!");
            throw new RuntimeException("获取上传图片流异常!", e);
        }
    }
}
