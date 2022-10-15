package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Receiver
 * @Description TODO
 * @Author LY
 * @Date 2020/10/29 21:31
 * @Version 1.0
 */
@Component
public class Receiver {

    /**
     * 接收消息
     * @param  msg
     */
    @RabbitListener(queues = {"hello-queue"})
    public void process(String msg){
        System.out.println("Receiver:" + msg);
    }
}
