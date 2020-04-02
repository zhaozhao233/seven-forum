package com.seven.forum.entity.hzw.message;

import com.seven.forum.entity.hzw.NfUserEasyEntity;
import com.seven.forum.entity.hzw.NfUserEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserAllMessageEntity { // 用户的所有通知实体类

//    private NfUserEasyEntity nfUserEasyEntity;  // 用户信息
    private int unreadCount;        // 用户未读通知数量
    private List<UserMessageTypeEntity> userMessageTypeEntityList;  // 通知类型集合

    @Override
    public String toString() {
        String messageTypeList = "";
        for (UserMessageTypeEntity userMessageTypeEntity : userMessageTypeEntityList) {
            messageTypeList += userMessageTypeEntity.toString();
        }
        return "UserAllMessageEntity{" +
                ", 未读通知数量：" + unreadCount +
                ", 通知分类：" + userMessageTypeEntityList +
                '}';
    }
}
