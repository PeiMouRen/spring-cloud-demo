package com.rhythm.service;

import com.rhythm.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface IStorageService {

    @PostMapping("/storage")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
