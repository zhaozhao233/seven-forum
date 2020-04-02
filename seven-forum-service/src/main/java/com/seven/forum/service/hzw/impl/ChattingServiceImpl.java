package com.seven.forum.service.hzw.impl;

import com.seven.forum.dao.hzw.NfMessageDao;
import com.seven.forum.dao.hzw.NfUserDao;
import com.seven.forum.dao.hzw.UserChattingDao;
import com.seven.forum.entity.hzw.NfUserEasyEntity;
import com.seven.forum.entity.hzw.chatting.BetweenUserChatting;
import com.seven.forum.entity.hzw.chatting.ChattingListEntity;
import com.seven.forum.entity.hzw.chatting.UserChattingEntity;
import com.seven.forum.service.hzw.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChattingServiceImpl implements ChattingService {

    @Autowired
    private UserChattingDao chattingDao;
    @Autowired
    private NfUserDao userDao;
    @Autowired
    private NfMessageDao messageDao;

    // 查询两个用户之间的聊天记录
    public BetweenUserChatting listChattingByBetweenUser(int sendUserId, int receiveUserId) {
        BetweenUserChatting betweenUserChatting = new BetweenUserChatting();
        List<UserChattingEntity> userChattingEntities = chattingDao.listChattingByBetweenUser(sendUserId, receiveUserId);
        NfUserEasyEntity user1 = userDao.getUserEasyByUserId(sendUserId);
        NfUserEasyEntity user2 = userDao.getUserEasyByUserId(receiveUserId);
        betweenUserChatting.setChattingList(userChattingEntities);
        betweenUserChatting.setSendUser(user1);
        betweenUserChatting.setReceiveUser(user2);
        return betweenUserChatting;
    }


    // 在聊天的用户列表（聊天的通知类型为暂时定为 4）
    public ChattingListEntity listChattingByUserId(int sendUserId) {
        ChattingListEntity chattingListEntity = new ChattingListEntity();
        chattingListEntity.setCountUnread(messageDao.countForNfMessageByUserIdType(sendUserId,4));
        chattingListEntity.setLastChatting(chattingDao.getLastChattingByBetweenUser(sendUserId));
        chattingListEntity.setUserEasyEntityList(listUserEasyInfoSolo(sendUserId));

        return chattingListEntity;
    }

    // 得到和我聊过天的用户基本信息
    public List<NfUserEasyEntity> listUserEasyInfoSolo(int sendUserId) {
        Set<UserChattingEntity> set = new HashSet();
        List<UserChattingEntity> userIdOneBySend = chattingDao.getUserIdOneBySend(sendUserId);
        List<UserChattingEntity> userIdOneByReceive = chattingDao.getUserIdOneByReceive(sendUserId);
        if (userIdOneBySend != null) {
            for (UserChattingEntity userChattingEntity : userIdOneBySend) {
                set.add(userChattingEntity);
            }
        }
        if (userIdOneByReceive != null) {
            for (UserChattingEntity userChattingEntity : userIdOneByReceive) {
                set.add(userChattingEntity);
            }
        }
        List<NfUserEasyEntity> listUserEasyInfo = new ArrayList<>();
        Iterator<UserChattingEntity> iterator = set.iterator();
        while (iterator.hasNext()) {
            UserChattingEntity next = iterator.next();
            if (next.getUserId() != null) {
                listUserEasyInfo.add(userDao.getUserEasyByUserId(next.getUserId()));
            } else {
                listUserEasyInfo.add(userDao.getUserEasyByUserId(next.getChattingUserId()));
            }

        }

        return listUserEasyInfo;
    }


    // 添加一条聊天记录
    public int insertChatting(UserChattingEntity chattingEntity) {
        return chattingDao.insertChatting(chattingEntity);
    }

    // 增加多条聊天记录
    public int insertChattingList(List<Integer> userIdList, UserChattingEntity userChattingEntity) {
        return chattingDao.insertChattingList(userIdList, userChattingEntity);
    }

    // 修改一条聊天记录状态
    public int updateChatting(int chattingId, int status) {
        return chattingDao.updateChatting(chattingId, status);
    }

    // 修改多条聊天记录状态
    public int updateChattingList(List<Integer> chattingIdList, int status) {
        return chattingDao.updateChattingList(chattingIdList, status);
    }

    // 删除一条聊天记录
    public int deleteChatting(int chattingId) {
        return chattingDao.deleteChatting(chattingId);
    }

    // 删除多条聊天记录
    public int deleteChattingList(List<Integer> chattingIdList) {
        return chattingDao.deleteChattingList(chattingIdList);
    }
}
