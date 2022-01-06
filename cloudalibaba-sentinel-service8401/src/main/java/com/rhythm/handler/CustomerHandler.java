package com.rhythm.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rhythm.entities.CommonResult;

/**
 * @Author peixi
 * @Date 2022/1/6
 * @Description
 */
public class CustomerHandler {

    public static CommonResult fallBackHandler1(BlockException exception) {
        return new CommonResult(4444, "global fallBackHandler1");
    }

    public static CommonResult blockHandler2(BlockException exception) {
        return new CommonResult(4444, "global blockHandler2");
    }
}
