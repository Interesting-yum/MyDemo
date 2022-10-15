package com.example.rabbitmqprovider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            this.sender.sendMessage("HELLO RABBITMQ!");
        }
    }

}
