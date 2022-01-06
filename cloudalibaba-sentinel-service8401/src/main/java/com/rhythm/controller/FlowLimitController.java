package com.rhythm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2022/1/5
 * @Description
 */
@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "testB");
        return "testB";
    }

    @GetMapping("/testD")
    public String testD() {
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int age = 10/0;
        log.info("testD 测试");
        return "testD";
    }


    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "deal_hotKey")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2) {
        return "test hotKey";
    }

    public String deal_hotKey(String p1, String p2, BlockException exception) {
        exception.printStackTrace();
        return "hotKey is Block!!!";
    }

}
