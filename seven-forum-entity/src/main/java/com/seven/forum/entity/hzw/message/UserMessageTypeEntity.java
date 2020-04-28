package com.seven.forum.entity.hzw.message;

import lombok.Data;

import java.util.List;

@Data
public class UserMessageTypeEntity {    // 通知类型实体类

    private MessageTypeEntity messageTypeEntity;        // 通知类型
    private int unreadCount;                            // 通知未读数量
    private List<NfMessageEntity> nfMessageEntityList;  // 通知内容

    @Override
    public String toString() {

        String messageList = "";
        if (nfMessageEntityList != null && nfMessageEntityList.size() > 0) {
            for (NfMessageEntity nfMessageEntity : nfMessageEntityList) {
                messageList += nfMessageEntity.toString();
            }
        }


        return "UserMessageTypeEntity{" +
                "通知类型：" + messageTypeEntity +
                ", 未读数量：" + unreadCount +
                ", 通知内容：" + messageList +
                '}';
    }
}
