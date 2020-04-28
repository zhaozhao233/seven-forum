package com.seven.forum.service.hzw.impl;

import com.seven.forum.dao.hzw.NfMessageDao;
import com.seven.forum.dao.hzw.NfUserDao;
import com.seven.forum.entity.hzw.NfUserEasyEntity;
import com.seven.forum.entity.hzw.message.MessageTypeEntity;
import com.seven.forum.entity.hzw.message.NfMessageEntity;
import com.seven.forum.entity.hzw.message.UserAllMessageEntity;
import com.seven.forum.entity.hzw.message.UserMessageTypeEntity;
import com.seven.forum.service.hzw.NfMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NfMessageServiceImpl implements NfMessageService {

    @Autowired
    private NfMessageDao nfMessageDao;  // 消息dao
    @Autowired
    private NfUserDao nfUserDao; // 用户信息dao


    // 用户的未读信息数量
    public int countUnreadNfMessageByUserId(int userId) {
        return nfMessageDao.countForNfMessageByUserId(userId);
    }

    // 根据用户ID查询出所有消息
    public UserAllMessageEntity getUserAllMessageByUserId(int userId) {
        UserAllMessageEntity message1 = new UserAllMessageEntity();     // 用户所有的消息
        List<UserMessageTypeEntity> listMessage2 = new ArrayList<>();   // 不同类型的消息集合
        List<MessageTypeEntity> messageType = nfMessageDao.listMessageType();        // 消息的类型
        // 得到所有的未读消息数量
        message1.setUnreadCount(nfMessageDao.countForNfMessageByUserId(userId));
        // 得到各个消息类型的消息
        for (MessageTypeEntity type1 : messageType) {
            UserMessageTypeEntity message2 = new UserMessageTypeEntity();
            message2.setMessageTypeEntity(type1);   // 注入消息类型
            message2.setUnreadCount(nfMessageDao.countForNfMessageByUserIdType(userId,type1.getMessageTypeId()));       // 注入消息数量
            message2.setNfMessageEntityList(nfMessageDao.listNfMessageByUserIdType(userId,type1.getMessageTypeId()));   // 注入消息内容
            listMessage2.add(message2);
        }
        message1.setUserMessageTypeEntityList(listMessage2);
        return message1;
    }


    // 根据用户ID查询指定类型消息
    @Override
    public UserMessageTypeEntity getUserMessageTypeByUserIdType(int userId, int messageTypeId) {
        UserMessageTypeEntity userMessageTypeEntity = new UserMessageTypeEntity();
        // 未读消息数量
        userMessageTypeEntity.setUnreadCount(nfMessageDao.countForNfMessageByUserIdType(userId, messageTypeId));
        List<NfMessageEntity> nfMessageEntities = nfMessageDao.listNfMessageByUserIdType(userId, messageTypeId);
        // set消息内容
        userMessageTypeEntity.setNfMessageEntityList(nfMessageEntities);
        // set消息类型
        userMessageTypeEntity.setMessageTypeEntity(nfMessageDao.getMessageType(messageTypeId));
        return userMessageTypeEntity;
    }

    // 已读所有消息
    public int updateReadNfMessageByUserId(int userId) {
        return nfMessageDao.updateReadNfMessageByUserId(userId);
    }

    // 已读指定消息
    public int updateReadNfMessageListByUserIdMessageId(int userId, List<Integer> messageIdList) {
        return nfMessageDao.updateReadNfMessageListByUserIdMessageId(userId,messageIdList);
    }

    // 已读某一类型消息
    public int updateReadNfMessageByUserIdType(int userId, int messageTypeId) {
        return nfMessageDao.updateReadNfMessageByUserIdType(userId,messageTypeId);
    }




    // 插入一条消息
    public int insertMessage(NfMessageEntity nfMessageEntity) {
        return nfMessageDao.insertMessage(nfMessageEntity);
    }

    // 添加一个消息类型
    public int insertMessageType(MessageTypeEntity messageTypeEntity) {
        return nfMessageDao.insertMessageType(messageTypeEntity);
    }

    // 批量插入消息
    public int insertMessageList(List<Integer> userIdList,NfMessageEntity nfMessageEntity){
        return nfMessageDao.insertMessageList(userIdList, nfMessageEntity);
    }




}
