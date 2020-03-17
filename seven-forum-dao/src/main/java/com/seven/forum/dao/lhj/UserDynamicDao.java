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
    List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,Integer dynamicId);

    //评论该动态
    void commentDynamic(Integer userId,Integer dynamicId,String commentContent);

    //回复
    void replyUser(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId);

    //发布动态
    void releaseDynamic(Integer userId,String dynamicContent);

    //添加评论数
    void addCommentCount(Integer dynamicId);
}
