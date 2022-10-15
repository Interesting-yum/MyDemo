package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName QueueTest
 * @Description 消息队列测试类
 * @Author LY
 * @Date 2020/10/29 21:35
 * @Version 1.0
 */
@SpringBootTest
public class QueueTest {

    @Autowired
    private Sender sender;
    /**
     * 测试消息队列
     */
    @Test
    public void test1() throws InterruptedException {
        while (true){
            new Thread( () -> sender.sendMessage("Hello RabbitMQ!")).start();
            Thread.sleep(1000);
        }
    }
}
