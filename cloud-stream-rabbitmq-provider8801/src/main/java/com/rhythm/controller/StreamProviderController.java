package com.rhythm.controller;

import com.rhythm.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2022/1/1
 * @Description
 */
@RestController
public class StreamProviderController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String getMessage() {
        return messageProvider.send();
    }

}
