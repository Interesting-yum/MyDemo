package com.example.rabbitmqtopicprovider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqTopicProviderApplicationTests {

    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;

    @Test
    void contextLoads() {
        this.userSender.sendMessage("用户服务LOG");
        this.productSender.sendMessage("商品服务LOG");
        this.orderSender.sendMessage("订单服务LOG");
    }

}
