package com.example.rabbitmqconsumer;

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
 *                key: 路由键
 * @Queue value: 配置队列名称
 *        autoDelete: 当所有消费客户端连接断开后，是否删除队列  true:删除   false:不删除
 * @Exchange value: 配置交换器名称
 *           type: 指定具体的交换器类型
 *           autoDelete: 当所有绑定队列都不再使用时，是否删除交换器  true:删除   false:不删除
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}",autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.info.routing.key}"
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
