package com.seven.forum.entity.zyl;


import lombok.Data;

import java.util.Date;

@Data
public class PostInfoEntity {

    private Long postId;
    private Long postBarId;
    private String postTitle;
    private String postContent;
    private Long userId;
    private Long topPost;
    private Long wonderfulPost;
    private Integer audit;
    private Long visitCount;
    private Integer postStatus;
    private Date createTime;

    @Override
    public String toString() {
        return "PostInfoEntity{" +
                "postId=" + postId +
                ", postBarId=" + postBarId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", userId=" + userId +
                ", topPost=" + topPost +
                ", wonderfulPost=" + wonderfulPost +
                ", visitCount=" + visitCount +
                ", postStatus=" + postStatus +
                ", createTime=" + createTime +
                '}';
    }
}
