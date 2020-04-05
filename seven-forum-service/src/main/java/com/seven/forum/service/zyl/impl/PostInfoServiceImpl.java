package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostBarInfoDAO;
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

    @Autowired
    private PostBarInfoDAO postBarInfoDAO;

    /**
     * 分页获取某个贴吧下的帖子信息
     *
     * @param postBarId 贴吧id
     * @param pageNum   页码
     * @param pageSize  页容量
     * @return
     */
    @Override
    public List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllPostInfos(postBarId, pageNum, pageSize);
    }

    /**
     * 获取某个贴吧下有多少帖子数
     *
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public Long countPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countPostInfoByPostBarId(postBarId);
    }

    /**
     * 分页获取某个贴吧的精品帖子
     *
     * @param postBarId 贴吧id
     * @param pageNum   页码
     * @param pageSize  页容量
     * @return
     */
    @Override
    public List<PostInfoEntity> listAllWonderfulPost(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllWonderfulPost(postBarId, pageNum, pageSize);
    }

    /**
     * 获取某个贴吧下有多少精品帖子
     *
     * @param postBarId 贴吧id
     * @return
     */
    @Override
    public Long countWonderfulPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countWonderfulPostInfoByPostBarId(postBarId);
    }

    /**
     * 主要是获取帖子的标题和作者id
     *
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
     *
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
     *
     * @param postId 帖子id
     * @return
     */
    @Override
    public PostBarInfoEntity getPostBarByPostId(Long postId) {
        return postInfoDAO.getPostBarByPostId(postId);
    }

    /**
     * 得到所有回帖的信息（包括被回复数）
     *
     * @param postId 帖子id
     * @return
     */
    @Override
    public List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listPostsAndCountReply(postId, pageNum, pageSize);
    }

    /**
     * 计算回帖数量
     *
     * @param postId 帖子id
     * @return
     */
    @Override
    public Long countReplyPosts(Long postId) {
        return postInfoDAO.countReplyPosts(postId);
    }

    /**
     * 通过帖子id得到所有回帖id，再由回帖id得到每一个回帖的所有回复
     *
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
     * 帖子表插入帖子信息，回帖表也要备份，然后贴吧帖子数+1
     *
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
        postBarInfoDAO.addPostCount(postInfoEntity.getPostBarId());
        return postId;
    }

    /**
     * 列出所有收藏夹
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<CollectGroup> listAllCollections(Long userId) {
        return postInfoDAO.listAllCollections(userId);
    }

    /**
     * 是否关注贴把
     *
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
     *
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
     *
     * @param userId    用户id
     * @param postBarId 帖子id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void insertFollowPostBar(Long userId, Long postBarId) {
        postInfoDAO.insertFollowPostBar(userId, postBarId);
        postBarInfoDAO.addUserCount(postBarId);
    }


    /**
     * 添加收藏信息
     *
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
     *
     * @param collectGroup 收藏夹信息
     */
    @Override
    public void insertFavorites(CollectGroup collectGroup) {
        postInfoDAO.insertFavorites(collectGroup);
    }

    /**
     * 在弹出的收藏夹里取消收藏
     *
     * @param collectId 收藏id
     */
    @Override
    public void deleteCollectionInCollections(Long collectId) {
        postInfoDAO.deleteCollectionInCollections(collectId);
    }

    /**
     * 在帖子界面取消收藏
     *
     * @param userId       用户id
     * @param collect0bjId 相当于帖子id
     */
    @Override
    public void deleteCollectionInPostInfo(Long userId, Long collect0bjId) {
        postInfoDAO.deleteCollectionInPostInfo(userId, collect0bjId);
    }

    /**
     * 删除收藏夹，先删除改收藏夹下的所有收藏再删除收藏夹
     *
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
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteFollowPostBar(Long userId, Long postBarId) {
        postInfoDAO.deleteFollowPostBar(userId, postBarId);
        postBarInfoDAO.reduceUserCount(postBarId);
    }

    // 同类的两个@Tranction方法互相调用，被调用的方法的事务失效

    /**
     * 修改回复不可见
     *
     * @param replyId 回复id
     */
    @Override
    public void updateReplyStatusByReplyId(Long replyId) {
        postInfoDAO.updateReplyStatusByReplyId(replyId);
    }

    /**
     * 修改回帖下的所有回复不可见
     *
     * @param replyPostId 回帖id
     */
    @Override
    public void updateReplyStatusByReplyPostId(Long replyPostId) {
        postInfoDAO.updateReplyStatusByReplyPostId(replyPostId);
    }

    /**
     * 修改整个帖子下所有回复不可见
     *
     * @param postId 帖子id
     */
    @Override
    public void updateReplyStatusByPostId(Long postId) {
        postInfoDAO.updateReplyStatusByPostId(postId);
    }

    /**
     * 修改回帖不可见
     *
     * @param replyPostId 回帖id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void updateReplyPostStatusByReplyPostId(Long replyPostId) {
        // 1楼回帖id
        Long firstReplyPostIdByReplyPostId = getFirstReplyPostIdByReplyPostId(replyPostId);
        if (firstReplyPostIdByReplyPostId.equals(replyPostId)) {
            // 如果是1楼，就是使整个帖子不可见
            Long postId = getPostIdByReplyPostId(replyPostId);
            // 使帖子不可见
            updatePostStatusByPostId(postId);
            // 使所有回帖和回复不可见
            updateReplyPostStatusByPostId(postId);
        } else {
            // 不是一楼,就使改回帖和改回帖下的所有回复不可见
            updateReplyStatusByReplyPostId(replyPostId);
            postInfoDAO.updateReplyPostStatusByReplyPostId(replyPostId);
        }
    }

    /**
     * 修改帖子下所有回帖和回复不可见
     *
     * @param postId 帖子id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void updateReplyPostStatusByPostId(Long postId) {
        updateReplyStatusByPostId(postId);
        postInfoDAO.updateReplyPostStatusByPostId(postId);
    }

    /**
     * 修改帖子不可见
     *
     * @param postId 帖子id
     */
    @Override
    public void updatePostStatusByPostId(Long postId) {
        postInfoDAO.updatePostStatusByPostId(postId);
    }


    /**
     * 改回帖的帖子的1楼回帖id
     *
     * @param replyPostId 回帖id
     * @return 1楼回帖id
     */
    @Override
    public Long getFirstReplyPostIdByReplyPostId(Long replyPostId) {
        return postInfoDAO.getFirstReplyPostIdByReplyPostId(replyPostId);
    }

    /**
     * 通过回帖id查出帖子id
     *
     * @param replyPostId 回帖id
     * @return 帖子id
     */
    @Override
    public Long getPostIdByReplyPostId(Long replyPostId) {
        return postInfoDAO.getPostIdByReplyPostId(replyPostId);
    }

    /**
     * 帖子是否存在
     *
     * @param postId 帖子id
     * @return 存在为1，不存在为null
     */
    @Override
    public Integer isExistsPost(Long postId) {
        return postInfoDAO.isExistsPost(postId);
    }


}
