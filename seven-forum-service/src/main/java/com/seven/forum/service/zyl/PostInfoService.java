package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostInfoService {

    List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

    PostInfoEntity getPostInfoById(Long postId);


    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, Integer pageNum, Integer pageSize);

    /**
     * 计算回帖数量
     *
     * @param postId 帖子id
     * @return
     */
    Long countReplyPosts(Long postId);

    List<ReplyInfoEntity> listRepliesByPostId(Long postId);

    /**
     * 只获取帖子中楼主的回帖
     *
     * @param postId 帖子id
     * @return
     */
    List<ReplyPostInfoEntity> listJustLandlordPostsAndCountReply(Long postId);

//    List<ReplyInfoEntity> listJustReplyInfosForLandlord(Long postId);

    /**
     * 添加回复
     *
     * @param replyInfoEntity 回复的信息
     */
    void insertReply(ReplyInfoEntity replyInfoEntity);

    void insertReplyPost(ReplyPostInfoEntity replyPostInfoEntity);

    /**
     * 发帖不仅要插入帖子表，还要回帖表备份一份
     *
     * @param postInfoEntity 帖子信息
     */
    Long insertPost(PostInfoEntity postInfoEntity);

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
     * 在弹出的收藏夹里取消收藏
     *
     * @param collectId 收藏id
     */
    void deleteCollectionInCollections(Long collectId);

    /**
     * 在帖子里取消收藏
     * @param userId 用户id
     * @param collect_obj_id 相当于帖子id
     */
    void deleteCollectionInPostInfo(Long userId, Long collect_obj_id);

    /**
     * 删除收藏夹
     *
     * @param collectGroupId 收藏夹id
     */
    void deleteFavorites(Long collectGroupId);

    /**
     * 取消关注贴吧
     * @param userId 用户id
     * @param postBarId 贴吧id
     */
    void deleteFollowPostBar(Long userId, Long postBarId);
}
