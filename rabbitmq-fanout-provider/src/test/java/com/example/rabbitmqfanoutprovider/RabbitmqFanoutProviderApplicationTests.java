package com.example.rabbitmqfanoutprovider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqFanoutProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() {
        this.sender.sendMessage("RABBITMQ测试");
    }

}
