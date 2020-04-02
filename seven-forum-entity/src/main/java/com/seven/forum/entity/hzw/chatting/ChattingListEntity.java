package com.seven.forum.entity.hzw.chatting;

import com.seven.forum.entity.hzw.NfUserEasyEntity;
import lombok.Data;

import java.util.List;

@Data
public class ChattingListEntity {   // 正在聊天的用户列表
    private List<NfUserEasyEntity> userEasyEntityList;  // 用户简单信息列表
    private UserChattingEntity lastChatting;            // 最后一条聊天信息
    private int countUnread;                            // 未读聊天数
}
