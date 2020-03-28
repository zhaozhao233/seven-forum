package com.seven.forum.entity.zyl;


import lombok.Data;

import java.util.Date;

@Data
public class ReplyInfoEntity {

    private Long replyId;
    private Long userId;
    private Long replyUserId;
    private Long replyPostId;
    private String replyContent;
    private Date replyTime;
    private Integer replyStatus;

    private String replyUserName;
    private NfUser nfUser;
}
