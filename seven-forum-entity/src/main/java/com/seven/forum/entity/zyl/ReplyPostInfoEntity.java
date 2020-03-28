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

    private Long storey;
    private Long replyCount;
    private NfUser nfUser;
}
