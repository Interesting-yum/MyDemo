package com.example.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Sender
 * @Description 消息发送者
 * @Author LY
 * @Date 2020/10/29 21:26
 * @Version 1.0
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 发送消息
     * @param msg
     */
    public void sendMessage(String msg){
        //向队列发送消息
        //参数1：队列的名称   参数2：消息
        this.amqpTemplate.convertAndSend("hello-queue",msg);
    }
}
