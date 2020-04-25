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
    public List<UserDynamicEntity> listHotDynamic() {
        return dynamicDao.listHotDynamic();
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
    //点赞动态and点赞数+1
    public void likeDynamicAndAddLikeCount(Integer likeObjId, Integer userId, Integer likeStatus, Integer dynamicId) {
        dynamicDao.likeDynamic(likeObjId,userId,likeStatus);
        dynamicDao.addLikeDynamicCount(dynamicId);
    }
    @Transactional
    @Override
    //点赞评论and点赞数+1
    public void likeCommentAndAddLikeCount(Integer likeObjId, Integer userId, Integer likeStatus, Integer commentId) {
        dynamicDao.likeComment(likeObjId,userId,likeStatus);
        dynamicDao.addLikeCommentCount(commentId);
    }

    @Override
    public Integer checkDynamicLike(Integer likeObj, Integer userId) {
        return dynamicDao.checkDynamicLike(likeObj, userId);
    }

    @Override
    public Integer checkCommentLike(Integer likeObj, Integer userId) {
        return dynamicDao.checkCommentLike(likeObj, userId);
    }

    @Override
    @Transactional
    //取消动态点赞and点赞数-1
    public void cancelDynamicLikeAndReduceLikeCount(Integer likeObjId, Integer userId, Integer dynamicId) {
        dynamicDao.cancelDynamicLike(likeObjId,userId);
        dynamicDao.reduceLikeDynamicCount(dynamicId);
    }

    @Override
    @Transactional
    //取消评论点赞and点赞数-1
    public void cancelCommentLikeAndReduceLikeCount(Integer likeObjId, Integer userId,Integer commentId) {
        dynamicDao.cancelCommentLike(likeObjId,userId);
        dynamicDao.reduceLikeCommentCount(commentId);
    }

    @Override
    @Transactional
    //动态   取消点赞后又点赞and点赞数+1
    public void dynamicLikeAgainAfterCancelLikeAndAddLikeCount(Integer likeObjId, Integer userId, Integer dynamicId) {
        dynamicDao.dynamicLikeAgainAfterCancelLike(likeObjId,userId);
        dynamicDao.addLikeDynamicCount(dynamicId);
    }

    @Override
    @Transactional
    //评论 取消点赞后又点赞and点赞数+1
    public void commentLikeAgainAfterCancelLikeAndAddLikeCommentCount(Integer likeObjId, Integer userId, Integer commentId) {
        dynamicDao.commentLikeAgainAfterCancelLike(likeObjId,userId);
        dynamicDao.addLikeCommentCount(commentId);
    }


}
