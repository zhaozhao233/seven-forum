package com.seven.forum.entity.hzw.chatting;

import com.seven.forum.entity.hzw.NfUserEasyEntity;
import com.seven.forum.entity.hzw.NfUserEntity;

import java.util.List;

public class UserAndUserChattingEntity {    // 用户与用户的聊天信息表

    private NfUserEasyEntity nfUserEasyEntity;      // 聊天对象的用户基本信息
    private List<UserChattingEntity> userChattingEntity;    // 用户聊天信息
}
