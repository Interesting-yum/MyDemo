package org.example.api;

import lombok.extern.slf4j.Slf4j;
import org.example.util.WebSocketServerPool;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @className: org.example.api.WebSocketServer
 * @title: WebSocketServer
 * @description: WebSocket服务端 当前链接地址：ws://localhost:8088/ws/ws/1
 * @author: LiuYun
 * @datetime: 2022/10/14 14:21
 * @version: 1.0.0
 */
@Component
@ServerEndpoint(value = "/ws/{screen}")
@Slf4j
public class WebSocketServer {

    /**
     * 建立连接成功调用 (Session + 场景)
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("screen") String screen) throws IOException {
        log.info("[onOpen][session({}) 接入, [screen: {}]", session, screen);
        WebSocketServerPool.addDataConnect(session, screen);
    }

    /**
     * 关闭连接时调用
     *
     * @param session 连接
     */
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("[onClose][session({}) 连接关闭。关闭原因是({})}]", session, closeReason);
        WebSocketServerPool.removeConnect(session);
    }

    /**
     * 错误时调用
     *
     * @param session   连接
     * @param throwable 异常
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.info("[onClose][session({}) 发生异常]", session, throwable);
        WebSocketServerPool.removeConnect(session);
    }

    /**
     * 收到客户端信息后，根据接收到的信息进行处理
     *
     * @param session 连接
     * @param message 数据消息
     */
    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        log.info("[onOpen][session({}) 接收到一条消息({})]", session, message);
        //对于客户端发送的指令信息，解析后进行对应的逻辑处理
        session.getBasicRemote().sendText(message);
    }
}
