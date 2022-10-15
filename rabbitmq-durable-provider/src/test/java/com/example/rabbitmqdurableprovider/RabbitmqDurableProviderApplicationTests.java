package com.example.rabbitmqdurableprovider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDurableProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() throws InterruptedException {
        int flag = 0;
        while (true) {
            flag ++;
            Thread.sleep(2000);
            this.sender.sendMessage("RABBITMQ测试 =>" + flag);
        }
    }

}
