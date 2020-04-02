package com.seven.forum.entity.hzw.chatting;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserChattingEntity { // 聊天信息实体类

    private Integer chattingId;         // 聊天ID
    private Integer userId;             // 发送ID
    private Integer chattingUserId;     // 接受ID
    private String chattingContent;     // 聊天内容
    private Timestamp chattingTime;     // 聊天时间
    private Integer chattingStatus;     // 聊天信息状态

    public UserChattingEntity() {

    }
}
