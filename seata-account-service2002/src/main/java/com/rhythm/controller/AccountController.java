package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PostMapping("/account")
    public CommonResult updateMoney(Long userId, BigDecimal money) {
        accountService.updateMoney(userId, money);

        return new CommonResult(200, "更新账户余额成功");
    }

}
