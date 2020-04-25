package com.seven.forum.service.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicService {
    List<UserDynamicEntity> listFollowUserDynamic(Integer pageNum,
                                                  Integer pageSize, Integer userId);

    List<UserDynamicEntity> listHotDynamic();

    List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,Integer dynamicId);


    void releaseDynamic(Integer userId,String dynamicContent);


    void commentDynamicWithAddCommentCount(Integer userId,Integer dynamicId,String commentContent,Integer commentStatus);

    void replyUserWithAddCommentCount(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId,Integer commentStatus);

    void likeDynamicAndAddLikeCount(Integer likeObjId,Integer userId,Integer likeStatus,Integer dynamicId);

    void likeCommentAndAddLikeCount(Integer likeObjId,Integer userId,Integer likeStatus,Integer commentId);

    Integer checkDynamicLike(Integer likeObjId,Integer userId);

    Integer checkCommentLike(Integer likeObjId,Integer userId);

    void cancelDynamicLikeAndReduceLikeCount(Integer likeObjId,Integer userId,Integer dynamicId);

    void cancelCommentLikeAndReduceLikeCount(Integer likeObjId,Integer userId,Integer commentId);

    void dynamicLikeAgainAfterCancelLikeAndAddLikeCount(Integer likeObjId,Integer userId,Integer dynamicId);

    void commentLikeAgainAfterCancelLikeAndAddLikeCommentCount(Integer likeObjId,Integer userId,Integer commentId);
}
