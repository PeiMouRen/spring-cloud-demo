package com.rhythm.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author peixi
 * @Date 2022/1/6
 * @Description
 */
public class MyHandler {

    public static String fallback(Long id, Throwable throwable) {
        return "id: " + id + " ,fallback handler" + throwable.getMessage();
    }

    public static String blockHandler(Long id, BlockException exception) {
        return "id: " + id + " ,block handler!!!" + exception.getMessage();
    }
}
