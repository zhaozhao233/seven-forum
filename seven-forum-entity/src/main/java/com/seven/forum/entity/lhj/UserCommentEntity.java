package com.seven.forum.entity.lhj;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserCommentEntity {//用户评论
    private Integer commentId;
    private Integer userId;
    private Integer dynamicId;
    private Integer dynamicStatus;
    private Integer replyUserId;
    private Timestamp commentTime;
    private Integer likeCount;
    private String commentContent;
    private Integer commentStatus;
}
