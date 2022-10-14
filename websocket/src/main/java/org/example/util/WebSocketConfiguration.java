package org.example.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @className: org.example.util.WebSocketConfiguration
 * @title: WebSocketConfiguration
 * @description: WebSocket配置类
 * @author: LiuYun
 * @datetime: 2022/10/14 13:47
 * @version: 1.0.0
 */
@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
