package com.example.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName QueueConfig
 * @Description 创建一个消息队列
 * @Author LY
 * @Date 2020/10/29 21:22
 * @Version 1.0
 */
@Configuration
public class QueueConfig {

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue createQueue(){
        return new Queue("hello-queue");
    }
}
