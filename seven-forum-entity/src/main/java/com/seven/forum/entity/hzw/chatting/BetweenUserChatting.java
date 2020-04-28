package com.seven.forum.entity.hzw.chatting;

import com.seven.forum.entity.hzw.NfUserEasyEntity;
import lombok.Data;

import java.util.List;

@Data
public class BetweenUserChatting {  // 用户之间的聊天记录

    private NfUserEasyEntity sendUser;      // 发送用户
    private NfUserEasyEntity receiveUser;   // 接收用户
    private List<UserChattingEntity> chattingList;  // 聊天记录集合

    public NfUserEasyEntity getSendUser() {
        return sendUser;
    }

    public void setSendUser(NfUserEasyEntity sendUser) {
        this.sendUser = sendUser;
    }

    public NfUserEasyEntity getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(NfUserEasyEntity receiveUser) {
        this.receiveUser = receiveUser;
    }

    public List<UserChattingEntity> getChattingList() {
        return chattingList;
    }

    public void setChattingList(List<UserChattingEntity> chattingList) {
        this.chattingList = chattingList;
    }
}
