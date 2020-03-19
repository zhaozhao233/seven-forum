package com.seven.forum.dao.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicDao {
    //显示关注人的动态
    List<UserDynamicEntity> listFollowUserDynamic(Integer pageNum,
                                                  Integer pageSize, Integer userId);

    //显示该动态的所有评论
    List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,
                                                   Integer dynamicId);

    //评论该动态
    void commentDynamic(Integer userId,Integer dynamicId,String commentContent,Integer commentStatus);

    //回复
    void replyUser(Integer userId,Integer dynamicId,
                   String commentContent,Integer replyUserId,Integer commentStatus);

    //发布动态
    void releaseDynamic(Integer userId,String dynamicContent);

    //评论数+1
    void addCommentCount(Integer dynamicId);

    //点赞动态
    void likeDynamic(Integer likeObjId,Integer userId,Integer likeStatus);

    //点赞评论
    void likeComment(Integer likeType, Integer likeObjId,Integer userId,Integer likeStatus);

    //动态点赞数+1
    void addLikeDynamicCount(Integer dynamicId);

    //评论点赞数+1
    void addLikeCommentCount(Integer commentId);




}
