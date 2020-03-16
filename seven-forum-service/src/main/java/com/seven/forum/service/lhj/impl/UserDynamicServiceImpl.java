package com.seven.forum.service.lhj.impl;

import com.seven.forum.dao.lhj.UserDynamicDao;
import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDynamicServiceImpl implements UserDynamicService {
    @Autowired
    private UserDynamicDao dynamicDao;


    @Override
    public List<UserDynamicEntity> listFollowUserDynamic(Integer pageNum, Integer pageSize, Integer userId) {
        return dynamicDao.listFollowUserDynamic(pageNum, pageSize, userId);
    }

    @Override
    public List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,Integer dynamicId) {
        return dynamicDao.listCommentByDynamicId(pageNum,pageSize,dynamicId);
    }

    @Override
    public void commentDynamic(Integer userId, Integer dynamicId, String commentContent) {
         dynamicDao.commentDynamic(userId,dynamicId,commentContent);
    }

    @Override
    public void replyUser(Integer userId, Integer dynamicId, String commentContent, Integer replyUserId) {
        dynamicDao.replyUser(userId,dynamicId,commentContent,replyUserId);
    }
}
