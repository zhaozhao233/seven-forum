package com.seven.forum.dao.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicDao {
    //显示关注人的动态
    List<UserDynamicEntity> listFollowUserDynamic(@Param("pageNum") Integer pageNum,
                                                  @Param("pageSize") Integer pageSize, Integer userId);
    //热门动态
    List<UserDynamicEntity> listHotDynamic();

    //显示该动态的所有评论
    List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,
                                                   Integer dynamicId);

    //评论该动态
    void commentDynamic(Integer userId,Integer dynamicId,String commentContent,Integer commentStatus);

    //回复
    void replyUser(Integer userId,Integer dynamicId,
                   String commentContent,Integer replyUserId,Integer commentStatus);

    //发布动态
    void releaseDynamic(@Param("userId") Integer userId,String dynamicContent);

    //评论数+1
    void addCommentCount(Integer dynamicId);

    //点赞动态
    void likeDynamic(Integer likeObjId,Integer userId,Integer likeStatus);

    //点赞评论
    void likeComment(Integer likeObjId,Integer userId,Integer likeStatus);

    //动态点赞数+1
    void addLikeDynamicCount(Integer dynamicId);

    //动态点赞数-1
    void reduceLikeDynamicCount(Integer dynamicId);

    //评论点赞数+1
    void addLikeCommentCount(Integer commentId);

    //评论点赞数-1
    void reduceLikeCommentCount(Integer commentId);

    //取消动态点赞
    void cancelDynamicLike(Integer dynamicId,Integer userId);

    //取消评论点赞
    void cancelCommentLike(Integer likeObjId,Integer userId);

    //查询对这个动态点过赞没
    Integer checkDynamicLike(Integer likeObjId,Integer userId);

    //查询对这个评论点过赞没
    Integer checkCommentLike(Integer likeObjId,Integer userId);

    //动态   取消点赞后又点赞
    void dynamicLikeAgainAfterCancelLike(Integer likeObjId,Integer userId);

    //评论   取消点点赞又再点赞
    void commentLikeAgainAfterCancelLike(Integer likeObjId,Integer userId);





}
