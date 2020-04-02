package com.seven.forum.entity.hzw.message;

import com.seven.forum.entity.hzw.NfUserEasyEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class NfMessageEntity {    // 用户通知实体类

    private Integer messageId;          // 消息ID
    private Integer userId;             // 通知用户ID
    private Integer messageTypeId;      // 通知类型
    private Integer messageRead;        // 通知是否已读
    private Integer authorId;           // 通知作者ID
    private String messageContent;  // 通知内容
    private Timestamp messageTime;  // 通知时间


    public NfMessageEntity() {

    }

    @Override
    public String toString() {
        return "NfMessageEntity{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", messageTypeId=" + messageTypeId +
                ", messageRead=" + messageRead +
                ", authorId=" + authorId +
                ", messageContent='" + messageContent + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
