package com.rhythm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

}
