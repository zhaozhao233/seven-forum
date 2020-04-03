package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostInfoService {

    List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

//    PostInfoEntity getPostInfoById(Long postId);

//    Integer countPostReplies(Long postId);

    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

//    List<ReplyPostInfoEntity> replyPostInfos(Long postId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, Integer pageNum, Integer pageSize);

    /**
     * 计算回帖数量
     * @param postId 帖子id
     * @return
     */
    Long countReplyPosts(Long postId);

    List<ReplyInfoEntity> listRepliesByPostId(Long postId);

    /**
     * 只获取帖子中楼主的回帖
     * @param postId 帖子id
     * @return
     */
    List<ReplyPostInfoEntity> listJustLandlordPostsAndCountReply(Long postId);

//    List<ReplyInfoEntity> listJustReplyInfosForLandlord(Long postId);

    /**
     * 添加回复
     * @param replyInfoEntity 回复的信息
     */
    void insertReply(ReplyInfoEntity replyInfoEntity);

    void insertReplyPost(ReplyPostInfoEntity replyPostInfoEntity);

    /**
     * 发帖不仅要插入帖子表，还要回帖表备份一份
     * @param postInfoEntity 帖子信息
     */
    Long insertPost(PostInfoEntity postInfoEntity);
}
