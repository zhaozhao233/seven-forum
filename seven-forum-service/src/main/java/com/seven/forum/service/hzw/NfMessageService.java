package com.seven.forum.service.hzw;

import com.seven.forum.entity.hzw.message.MessageTypeEntity;
import com.seven.forum.entity.hzw.message.NfMessageEntity;
import com.seven.forum.entity.hzw.message.UserAllMessageEntity;
import com.seven.forum.entity.hzw.message.UserMessageTypeEntity;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.util.List;

@Service
public interface NfMessageService {

//    // 查询指定用户所有没被查看的消息
//    List<NfMessageEntity> listAllPartitionsAndCatalogues(int userId);
//    // 查询指定用户所有信息
//    List<NfMessageEntity> listNfMessageByUserId(int userId);
//    // 查询消息类型
//    List<MessageTypeEntity> listMessageType();

//  查询指定用户的未读信息的数量
    int countUnreadNfMessageByUserId(int userId);
    // 根据用户ID查询出所有消息
    UserAllMessageEntity getUserAllMessageByUserId(int userId);
    // 根据用户ID查询指定类型消息
    UserMessageTypeEntity getUserMessageTypeByUserIdType(int userId, int messageTypeId);

    // 将指定用户未读消息变为已读
    int updateReadNfMessageByUserId(int userId);
    // 将指定用户的指定未读信息批量变为已读
    int updateReadNfMessageListByUserIdMessageId(int userId, List<Integer> messageIdList);
    // 将用户某一类型的信息变为已读
    int updateReadNfMessageByUserIdType(int userId, int messageTypeId);


    // 插入一条消息
    int insertMessage(NfMessageEntity nfMessageEntity);
    // 批量插入消息
    int insertMessageList(List<Integer> userIdList,NfMessageEntity nfMessageEntity);


}
