package com.example.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDurableConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDurableConsumerApplication.class, args);
    }

}
