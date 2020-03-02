package com.seven.forum.entity.zyl;


import lombok.Data;

import java.util.Date;

@Data
public class ReplyPostInfoEntity {

    private Long replyPostId;
    private Long postId;
    private Long userId;
    private String replyPostContent;
    private Date createTime;
    private Integer topReplyPost;
    private Integer replyStatus;


    @Override
    public String toString() {
        return "ReplyPostInfoEntity{" +
                "replyPostId=" + replyPostId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", replyPostContent='" + replyPostContent + '\'' +
                ", createTime=" + createTime +
                ", topReplyPost=" + topReplyPost +
                ", replyStatus=" + replyStatus +
                '}';
    }
}
