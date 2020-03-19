package com.seven.forum.service.lhj.impl;

import com.seven.forum.dao.lhj.UserDynamicDao;
import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void releaseDynamic(Integer userId, String dynamicContent) {
        dynamicDao.releaseDynamic(userId,dynamicContent);
    }

    @Transactional
    @Override
    //评论~and~动态评论数+1
    public void commentDynamicWithAddCommentCount(Integer userId, Integer dynamicId, String commentContent,Integer commentStatus) {
        dynamicDao.commentDynamic(userId,dynamicId,commentContent,commentStatus);
        dynamicDao.addCommentCount(dynamicId);
    }

    @Transactional
    @Override
    //回复~and~动态评论数+1
    public void replyUserWithAddCommentCount(Integer userId, Integer dynamicId, String commentContent, Integer replyUserId,Integer replyStatus) {
        dynamicDao.replyUser(userId,dynamicId,commentContent,replyUserId,replyStatus);
        dynamicDao.addCommentCount(dynamicId);

    }

    @Transactional
    @Override
    public void likeDynamicAndAddLikeCount(Integer likeObjId, Integer userId, Integer likeStatus, Integer dynamicId) {
        dynamicDao.likeDynamic(likeObjId,userId,likeStatus);
        dynamicDao.addLikeDynamicCount(dynamicId);
    }
    @Transactional
    @Override
    public void likeCommentAndAddLikeCount(Integer likeType, Integer likeObjId, Integer userId, Integer likeStatus, Integer commentId) {
        dynamicDao.likeComment(likeType,likeObjId,userId,likeStatus);
        dynamicDao.addLikeCommentCount(commentId);
    }


}
