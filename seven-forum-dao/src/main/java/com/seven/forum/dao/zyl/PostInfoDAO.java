package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostInfoDAO {

    void updateVisitCount(Long postId);

    List<PostInfoEntity> listEightPopularPostInfo();

    List<PostInfoEntity> listPopularPostInfo(Integer size);

    List<PostInfoEntity> listAllPostInfos(Long postBarId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

    PostInfoEntity getPostInfoById(Long postId);

    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countReplyPosts(Long postId);

    List<Long> listReplyPostIdsByPostId(Long postId);

    List<ReplyInfoEntity> listRepliesInReplyPostByPostId(List<Long> replyPostId);

    /**
     * 只查询帖子中楼主的回帖
     *
     * @param postId 帖子id
     * @return
     */
    List<ReplyPostInfoEntity> listJustLandlordPostsAndCountReply(Long postId);

    /**
     * 所有收藏列表
     *
     * @param userId 用户id
     * @return
     */
    List<CollectGroup> listAllCollections(Long userId);

    /**
     * 判断是否关注了贴吧
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     * @return 1就是关注了
     */
    Integer isFollowPostBar(Long userId, Long postBarId);

    /**
     * 是否收藏了帖子
     *
     * @param userId       用户id
     * @param collectObjId 帖子id
     * @return
     */
    Integer isCollectPost(Long userId, Long collectObjId);

    /**
     * 关注贴吧
     *
     * @param userId    用户id
     * @param postBarId 帖子id
     */
    void insertFollowPostBar(Long userId, Long postBarId);

    /**
     * 收藏帖子
     *
     * @param userCollect 收藏信息
     * @return 收藏帖子的编号，用于撤销收藏
     */
    Long insertCollectPost(UserCollect userCollect);

    /**
     * 创建收藏夹
     *
     * @param collectGroup 收藏夹信息
     */
    void insertFavorites(CollectGroup collectGroup);

    /**
     * 添加回复
     *
     * @param replyInfoEntity 回复的信息
     */
    void insertReply(ReplyInfoEntity replyInfoEntity);

    void insertReplyPost(ReplyPostInfoEntity replyPostInfoEntity);

    /**
     * 插入帖子信息
     *
     * @param postInfoEntity 帖子信息
     * @return
     */
    void insertPost(PostInfoEntity postInfoEntity);

    /**
     * 取消收藏
     *
     * @param collectId 收藏id
     */
    void deleteCollectionInCollections(Long collectId);

    /**
     * 在帖子界面取消收藏
     *
     * @param userId       用户id
     * @param collectObjId 相当于帖子id
     */
    void deleteCollectionInPostInfo(Long userId, Long collectObjId);

    /**
     * 删除收藏夹
     *
     * @param collectGroupId 收藏夹id
     */
    void deleteFavorites(Long collectGroupId);

    /**
     * 删除收藏夹前，先删除其下所有收藏
     *
     * @param collectGroupId 收藏夹id
     */
    void deleteCollections(Long collectGroupId);

    /**
     * 取消关注贴吧
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     */
    void deleteFollowPostBar(Long userId, Long postBarId);

    /**
     * 修改某个回复不可见
     *
     * @param replyId 回复id
     */
    void updateReplyStatusByReplyId(Long replyId);

    /**
     * 修改某个回帖下的所有回复不可见
     *
     * @param replyPostId 回帖id
     */
    void updateReplyStatusByReplyPostId(Long replyPostId);

    /**
     * 修改帖子下的所有回复不可见
     *
     * @param postId 帖子id
     */
    void updateReplyStatusByPostId(Long postId);


    /**
     * 修改某个回帖不可见
     *
     * @param replyPostId 回帖id
     */
    void updateReplyPostStatusByReplyPostId(Long replyPostId);

    /**
     * 修改整个帖子下的所有回帖不可见
     *
     * @param postId 帖子id
     */
    void updateReplyPostStatusByPostId(Long postId);

    /**
     * 修改帖子不可见
     *
     * @param postId 帖子id
     */
    void updatePostStatusByPostId(Long postId);

    /**
     * 修改一个回帖为不可见之前看该帖子下的1楼回帖id
     *
     * @param replyPostId 回帖id
     * @return 1楼回帖id
     */
    Long getFirstReplyPostIdByReplyPostId(Long replyPostId);

    /**
     * 通过回帖id查出帖子id
     *
     * @param replyPostId 回帖id
     * @return 帖子id
     */
    Long getPostIdByReplyPostId(Long replyPostId);

    /**
     * 帖子是否存在
     *
     * @param postId 帖子id
     * @return 存在为1，不存在为null
     */
    Integer isExistsPost(Long postId);
}
