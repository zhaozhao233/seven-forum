package com.seven.forum.dao.hzw;

import com.seven.forum.entity.hzw.message.MessageTypeEntity;
import com.seven.forum.entity.hzw.message.NfMessageEntity;
import com.seven.forum.entity.hzw.message.UserAllMessageEntity;
import com.seven.forum.entity.hzw.message.UserMessageTypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NfMessageDao {

    // 查询指定用户所有没被查看的消息
    List<NfMessageEntity> listUnreadNfMessageByUserId(@Param("userId") int userId);
    // 查询指定用户所有信息
    List<NfMessageEntity> listNfMessageByUserId(@Param("userId") int userId);
    // 查询指定用户的未读信息的数量
    int countForNfMessageByUserId(@Param("userId") int userId);
    // 查询指定用户的指定类型的消息
    List<NfMessageEntity> listNfMessageByUserIdType(@Param("userId") int userId, @Param("messageType") int messageType);
    // 查询指定用户的指定类型的未读消息数量
    int countForNfMessageByUserIdType(@Param("userId") int userId, @Param("messageType") int messageType);
    // 查询所有消息类型
    List<MessageTypeEntity> listMessageType();
    // 查询指定消息类型
    MessageTypeEntity getMessageType(@Param("messageTypeId") int messageTypeId);



    // 将指定用户未读消息变为已读
    int updateReadNfMessageByUserId(@Param("userId") int userId);
    // 将指定用户的指定未读信息批量变为已读
    int updateReadNfMessageListByUserIdMessageId(@Param("userId") int userId, @Param("messageIdList") List<Integer> messageIdList);
    // 将指定用户的指定类型的未读消息变为已读
    int updateReadNfMessageByUserIdType(@Param("userId") int userId, @Param("messageType") int messageType);


    // 添加一个消息类型
    int insertMessageType(@Param("messageType") MessageTypeEntity messageTypeEntity);
    // 插入一条消息
    int insertMessage(@Param("message")NfMessageEntity nfMessageEntity);
    // 群发消息
    int insertMessageList(@Param("userIdList") List<Integer> userIdList,@Param("message") NfMessageEntity nfMessageEntity);

}
