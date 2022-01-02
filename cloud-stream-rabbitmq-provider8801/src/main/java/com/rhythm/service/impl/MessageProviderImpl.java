package com.rhythm.service.impl;

import com.rhythm.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @Author peixi
 * @Date 2022/1/1
 * @Description
 */
@EnableBinding(Source.class) // 开启消息的推送
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serialno = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serialno).build());
        return serialno;
    }
}
