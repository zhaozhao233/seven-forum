package com.seven.forum.config.hzw.websocket;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/server/{id}") // websocket
@Component  // 被 spring IOC 容器管理
@Slf4j  // 日志
public class WebSocketServer {
    // 连接人数
    private static int onlineCount = 0;
    // 存放连接到websocket服务的用户
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    private Session session;

    private String userId = "";

    // 获得连接人数
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    // 连接人数+1
    public static synchronized void addOnlineCount() {
        onlineCount ++;
    }

    // 连接人数-1
    public synchronized void subOnlineCount() {
        onlineCount --;
    }

    // 发送消息
    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    // 发送信息到指定用户
    public static void sendInfo(String message,@PathParam("userId")String userId) throws IOException {
        log.info("发送信息到："+userId+"，报文:"+message);
        if (StringUtils.isNotBlank(userId)&&webSocketMap.containsKey(userId)) {
            webSocketMap.get(userId).sendMessage(message);
        } else {
            log.error("用户"+userId+"不存在");
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("id")String userId) {
        this.session = session;
        this.userId = userId;
        if (!webSocketMap.containsKey(userId)) {    // 如果是第一次连接
            webSocketMap.put(userId,this);          // 将用户添加到Map
            addOnlineCount();                       // 连接人数+1
        }
        log.info("用户[" + userId + "]连接，当前人数为"+getOnlineCount());
        try {
            sendMessage("连接成功onOpen");
        } catch (IOException e) {
            log.info("用户["+userId+"]网络异常！");
        }
    }

    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(userId)) {     // 如果用户还在Map中
            webSocketMap.remove(userId);            // Map移除userID
            subOnlineCount();                       // 人数-1
        }
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("用户["+userId+"]报文"+message);
        if (StringUtils.isNotBlank(message)) {      // 如果不为空
            JSONObject jsonObject = JSON.parseObject(message);  // 转换成object
            jsonObject.put("fromUserId",this.userId);
            String toUserId = jsonObject.getString("toUserId"); // 获取object中toUserId字段;
            if (StringUtils.isNotBlank(toUserId) && webSocketMap.containsKey(toUserId)) {   // userId不为空且Map里面有userId
                try {
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());  // 转为JSON字符串，发送message
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                log.error("请求的userId:"+toUserId+"不在该服务器上");
            }
        }
    }

    @OnError
    public void onError(Throwable error) {
        log.error("用户错误"+userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }


}









