package com.usher.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: Usher
 * @Description:
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSockets.size());
    }

    @OnClose
    public void onClose() {
        //从set中删除
        webSockets.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSockets.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    /**
     * 广播消息
     *
     * @param message
     */
    public void sendMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @OnError
     */
    public void onError(Session session, Throwable error) {
        log.info("发生错误");
        error.printStackTrace();
    }


}
