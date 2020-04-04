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
     * 主要是获取帖子的标题和作者id
     * @param postId 帖子id
     * @return
     */
    @Override
    public PostInfoEntity getPostInfoById(Long postId) {
        return postInfoDAO.getPostInfoById(postId);
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
     * 列出所有收藏夹
     * @param userId 用户id
     * @return
     */
    @Override
    public List<CollectGroup> listAllCollections(Long userId) {
        return postInfoDAO.listAllCollections(userId);
    }

    /**
     * 是否关注贴把
     * @param userId    用户id
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public Integer isFollowPostBar(Long userId, Long postBarId) {
        return postInfoDAO.isFollowPostBar(userId, postBarId);
    }

    /**
     * 是否收藏帖子
     * @param userId       用户id
     * @param collectObjId 帖子id
     * @return
     */
    @Override
    public Integer isCollectPost(Long userId, Long collectObjId) {
        return postInfoDAO.isCollectPost(userId, collectObjId);
    }

    /**
     * 关注贴吧
     * @param userId    用户id
     * @param postBarId 帖子id
     */
    @Override
    public void insertFollowPostBar(Long userId, Long postBarId) {
        postInfoDAO.insertFollowPostBar(userId, postBarId);
    }


    /**
     * 添加收藏信息
     * @param userCollect 收藏信息
     * @return 收藏id，自增长生成
     */
    @Override
    public Long insertCollectPost(UserCollect userCollect) {
        postInfoDAO.insertCollectPost(userCollect);
        return userCollect.getCollectId();
    }

    /**
     * 添加收藏夹
     * @param collectGroup 收藏夹信息
     */
    @Override
    public void insertFavorites(CollectGroup collectGroup) {
        postInfoDAO.insertFavorites(collectGroup);
    }

    /**
     * 在弹出的收藏夹里取消收藏
     * @param collectId 收藏id
     */
    @Override
    public void deleteCollectionInCollections(Long collectId) {
        postInfoDAO.deleteCollectionInCollections(collectId);
    }

    /**
     * 在帖子界面取消收藏
     * @param userId 用户id
     * @param collect0bjId 相当于帖子id
     */
    @Override
    public void deleteCollectionInPostInfo(Long userId, Long collect0bjId) {
        postInfoDAO.deleteCollectionInPostInfo(userId, collect0bjId);
    }

    /**
     * 删除收藏夹，先删除改收藏夹下的所有收藏再删除收藏夹
     * @param collectGroupId 收藏夹id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteFavorites(Long collectGroupId) {
        postInfoDAO.deleteCollections(collectGroupId);
        postInfoDAO.deleteFavorites(collectGroupId);
    }

    /**
     * 取消关注贴吧
     * @param userId 用户id
     * @param postBarId 贴吧id
     */
    @Override
    public void deleteFollowPostBar(Long userId, Long postBarId) {
        postInfoDAO.deleteFollowPostBar(userId, postBarId);
    }

}
