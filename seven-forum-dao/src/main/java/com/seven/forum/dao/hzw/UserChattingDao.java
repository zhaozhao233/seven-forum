package com.seven.forum.dao.hzw;

import com.seven.forum.entity.hzw.chatting.BetweenUserChatting;
import com.seven.forum.entity.hzw.chatting.UserChattingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserChattingDao {

    // 查询用户之间的聊天记录
    List<UserChattingEntity> listChattingByBetweenUser(@Param("sendUserId") int sendUserId, @Param("receiveUserId") int receiveUserId);
    // 查询用户之间的最后一条聊天记录
    UserChattingEntity getLastChattingByBetweenUser(@Param("sendUserId") int sendUserId);
    //
    List<UserChattingEntity> getUserIdOneByReceive(@Param("receiveUserId") int receiveUserId);
    //
    List<UserChattingEntity> getUserIdOneBySend(@Param("sendUserId") int sendUserId);


    // 插入一条聊天记录
    int insertChatting(@Param("chatting") UserChattingEntity userChattingEntity);
    // 群发聊天信息
    int insertChattingList(@Param("userIdList") List<Integer> userIdList, @Param("chatting") UserChattingEntity userChattingEntity);

    // 修改一条聊天记录状态
    int updateChatting(@Param("chattingId") int chattingId, @Param("status") int status);
    // 修改多条聊天记录状态
    int updateChattingList(@Param("chattingIdList") List<Integer> chattingIdList, @Param("status") int status);

    // 删除一条聊天记录
    int deleteChatting(@Param("chattingId") int chattingId);
    // 删除多条聊天记录
    int deleteChattingList(@Param("chattingIdList") List<Integer> chattingIdList);
}
