package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private IStorageService storageService;


    @PostMapping("/storage")
    public CommonResult updateCount(Long productId, Integer count) {
        storageService.updateCount(productId, count);
        return new CommonResult(200, "更新库存成功");
    }
}
