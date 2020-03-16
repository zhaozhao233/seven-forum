package com.seven.forum.service.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicService {
    List<UserDynamicEntity> listFollowUserDynamic(Integer pageNum,
                                                  Integer pageSize, Integer userId);

    List<UserCommentEntity> listCommentByDynamicId(Integer pageNum,Integer pageSize,Integer dynamicId);

    void commentDynamic(Integer userId,Integer dynamicId,String commentContent);

    void replyUser(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId);
}