package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostInfoDAO;
import com.seven.forum.entity.zyl.*;
import com.seven.forum.service.zyl.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostInfoServiceImpl implements PostInfoService {
    @Autowired
    private PostInfoDAO postInfoDAO;

    /**
     * 分页获取某个贴吧下的帖子信息
     * @param postBarId 贴吧id
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return
     */
    @Override
    public List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllPostInfos(postBarId, pageNum, pageSize);
    }

    /**
     * 获取某个贴吧下有多少帖子数
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public Long countPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countPostInfoByPostBarId(postBarId);
    }

    /**
     * 分页获取某个贴吧的精品帖子
     * @param postBarId 贴吧id
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return
     */
    @Override
    public List<PostInfoEntity> listAllWonderfulPost(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllWonderfulPost(postBarId, pageNum, pageSize);
    }

    /**
     * 获取某个贴吧下有多少精品帖子
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public Long countWonderfulPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countWonderfulPostInfoByPostBarId(postBarId);
    }

    /**
     * 通过帖子id获取其详细信息
     * @param postId 帖子id
     * @return
     */
//    @Override
//    public PostInfoEntity getPostInfoById(Long postId) {
//        return postInfoDAO.getPostInfoById(postId);
//    }

    /**
     * 获取某个帖子的回复数
     * @param postId 帖子id
     * @return
     */
//    @Override
//    public Integer countPostReplies(Long postId) {
//        return postInfoDAO.countPostReplies(postId);
//    }

    /**
     * 通过贴吧id获取其所属分类信息
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId) {
        return postInfoDAO.getCatalogueByPostBarId(postBarId);
    }

    /**
     * 通过帖子id获取其下所有回帖信息
     * @param postId 帖子id
     * @return
     */
//    @Override
//    public List<ReplyPostInfoEntity> replyPostInfos(Long postId) {
//        return postInfoDAO.replyPostInfos(postId);
//    }

    /**
     * 通过帖子id得到其所在贴吧的信息
     * @param postId 帖子id
     * @return
     */
    @Override
    public PostBarInfoEntity getPostBarByPostId(Long postId) {
        return postInfoDAO.getPostBarByPostId(postId);
    }

    /**
     * 得到所有回帖的信息（包括被回复数）
     * @param postId 帖子id
     * @return
     */
    @Override
    public List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listPostsAndCountReply(postId, pageNum, pageSize);
    }

    /**
     * 计算回帖数量
     * @param postId 帖子id
     * @return
     */
    @Override
    public Long countReplyPosts(Long postId) {
        return postInfoDAO.countReplyPosts(postId);
    }

    /**
     * 通过帖子id得到所有回帖id，再由回帖id得到每一个回帖的所有回复
     * @param postId 帖子id
     * @return
     */
    @Override
    public List<ReplyInfoEntity> listRepliesByPostId(Long postId) {
        List<Long> replyPostIds = postInfoDAO.listReplyPostIdsByPostId(postId);
        List<ReplyInfoEntity> replyInfoEntities = postInfoDAO.listRepliesInReplyPostByPostId(replyPostIds);
        return replyInfoEntities;
    }

    @Override
    public List<ReplyPostInfoEntity> listJustLandlordPostsAndCountReply(Long postId) {
        return postInfoDAO.listJustLandlordPostsAndCountReply(postId);
    }

    @Override
    public void insertReply(ReplyInfoEntity replyInfoEntity) {
        postInfoDAO.insertReply(replyInfoEntity);
    }

    @Override
    public void insertReplyPost(ReplyPostInfoEntity replyPostInfoEntity) {
        postInfoDAO.insertReplyPost(replyPostInfoEntity);
    }

    /**
     * 帖子表插入帖子信息，回帖表也要备份
     * @param postInfoEntity 帖子信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Long insertPost(PostInfoEntity postInfoEntity) {
        postInfoDAO.insertPost(postInfoEntity);
        Long postId = postInfoEntity.getPostId();
        ReplyPostInfoEntity replyPostInfoEntity = new ReplyPostInfoEntity();
        replyPostInfoEntity.setPostId(postId);
        replyPostInfoEntity.setUserId(postInfoEntity.getUserId());
        replyPostInfoEntity.setReplyPostContent(postInfoEntity.getPostContent());
        postInfoDAO.insertReplyPost(replyPostInfoEntity);
        return postId;
    }

    /**
     * 只获取回复楼主的回复
     * @param postId
     * @return
     */
//    @Override
//    public List<ReplyInfoEntity> listJustReplyInfosForLandlord(Long postId) {
//        List<Long> landlordReplyPostIds = postInfoDAO.listJustLandlordReplyPostIdsByPostId(postId);
//        List<ReplyInfoEntity> replyInfoEntities = postInfoDAO.listRepliesInReplyPostByPostId(landlordReplyPostIds);
//        return replyInfoEntities;
//    };


}
