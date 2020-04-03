package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostInfoDAO {

    List<PostInfoEntity> listAllPostInfos(Long postBarId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

    PostInfoEntity getPostInfoById(Long postId);

    Integer countPostReplies(Long postId);

    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

    List<ReplyPostInfoEntity> replyPostInfos(Long postId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Long countReplyPosts(Long postId);

    List<Long> listReplyPostIdsByPostId(Long postId);

    List<ReplyInfoEntity> listRepliesInReplyPostByPostId(List<Long> replyPostId);

    /**
     * 某个帖子下楼主的所有回帖id
     * @param postId 帖子id
     * @return
     */
//    List<Long> listJustLandlordReplyPostIdsByPostId(Long postId);

    /**
     * 只查询帖子中楼主的回帖
     *
     * @param postId 帖子id
     * @return
     */
    List<ReplyPostInfoEntity> listJustLandlordPostsAndCountReply(Long postId);

    /**
     * 添加回复
     *
     * @param replyInfoEntity 回复的信息
     */
    void insertReply(ReplyInfoEntity replyInfoEntity);

    void insertReplyPost(ReplyPostInfoEntity replyPostInfoEntity);

    /**
     * 插入帖子信息
     * @param postInfoEntity 帖子信息
     * @return
     */
    void insertPost(PostInfoEntity postInfoEntity);
}
