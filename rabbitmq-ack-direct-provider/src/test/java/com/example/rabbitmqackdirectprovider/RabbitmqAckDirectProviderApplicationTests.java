package com.example.rabbitmqackdirectprovider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqAckDirectProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() {
        this.sender.sendMessage("RABBITMQ ack 测试");
    }


}
