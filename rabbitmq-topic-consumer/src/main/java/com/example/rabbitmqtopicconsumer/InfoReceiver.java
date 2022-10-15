package com.example.rabbitmqtopicconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName ErrorReceiver
 * @Description 消息接收者 INFO
 * @Author LY
 * @Date 2020/10/29 21:31
 * @Version 1.0
 * @RabbitListener bindings: 绑定队列
 * @QueueBinding value: 绑定队列的名称
 *                exchange: 配置交换器
 * @Queue value: 配置队列名称
 *        autoDelete: 是否是一个可删除的临时队列
 * @Exchange value: 配置交换器名称
 *           type: 指定具体的交换器类型
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC),
                key = "*.log.info"
        )
)
public class InfoReceiver {

    /**
     * 接收消息
     * @param  msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("InfoReceiver:" + msg);
    }
}
