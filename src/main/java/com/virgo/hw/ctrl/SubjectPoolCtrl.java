package com.virgo.hw.ctrl;

import com.virgo.hw.bean.anno.CustomResponseAdvice;
import com.virgo.hw.bean.commom.PageData;
import com.virgo.hw.bean.commom.Resp;
import com.virgo.hw.bean.dto.SubjectPoolDTO;
import com.virgo.hw.bean.dto.SubjectQueryDTO;
import com.virgo.hw.bean.vo.SubjectPoolResultVO;
import com.virgo.hw.bean.vo.SubjectPoolVO;
import com.virgo.hw.exception.ServiceException;
import com.virgo.hw.service.ISubjectPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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

    @PostMapping("subject/pool/collect")
    @CustomResponseAdvice
    public Resp<String> photoCollect(@RequestParam("file") MultipartFile file) {
        try {
            return Resp.ok(subjectPoolService.photoCollect(file.getInputStream()));
        } catch (IOException e) {
            log.error("获取上传图片流异常!");
            throw new ServiceException("获取上传图片流异常!", e);
        }
    }

    @PostMapping("subject/pool")
    public List<SubjectPoolVO> subject(@RequestBody SubjectQueryDTO dto) {
        return subjectPoolService.findEntity(dto);
    }

    @PostMapping("subject/pool/list")
    public PageData<SubjectPoolResultVO> listSubject(@RequestBody SubjectQueryDTO dto) {
        return subjectPoolService.listSubject(dto);
    }

    @GetMapping("subject/delete")
    public Integer delete(@RequestParam("subjectId") String subjectId) {
        return subjectPoolService.deleteEntity(subjectId);
    }

    @PostMapping("subject/pool/edit")
    public Integer editEntity(@RequestBody SubjectPoolDTO dto) {
        return subjectPoolService.editEntity(dto);
    }

    @PostMapping("subject/list/by/ids")
    public List<SubjectPoolResultVO> listSubjectVO(@RequestBody SubjectQueryDTO dto) {
        return subjectPoolService.listSubjectVO(dto.getSubjectIds());
    }
}
