package com.seven.forum.service.hzw;

import com.seven.forum.entity.hzw.chatting.BetweenUserChatting;
import com.seven.forum.entity.hzw.chatting.ChattingListEntity;
import com.seven.forum.entity.hzw.chatting.UserChattingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChattingService {

    // 查询用户之间的聊天记录
    BetweenUserChatting listChattingByBetweenUser(int sendUserId, int receiveUserId);
    // 在聊天的用户列表
    ChattingListEntity listChattingByUserId(int sendUserId);

    // 添加一条聊天记录
    int insertChatting(UserChattingEntity chattingEntity);
    // 增加多条聊天记录
    int insertChattingList(List<Integer> userIdList, UserChattingEntity userChattingEntity);

    // 修改一条聊天记录状态
    int updateChatting(int chattingId, int status);
    // 修改多条聊天记录状态
    int updateChattingList(List<Integer> chattingIdList, int status);

    // 删除一条聊天记录
    int deleteChatting(int chattingId);
    // 删除多条聊天记录
    int deleteChattingList(List<Integer> chattingIdList);
}
