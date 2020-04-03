package com.seven.forum.entity.zyl;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class ReplyInfoEntity {

    private Long replyId;
    private Long userId;
    private Long replyUserId;
    private Long replyPostId;
    @Length(max = 128, message = "字数超过限制")
    private String replyContent;
    private Date replyTime;
    private Integer replyStatus;

    private String replyUserName;
    private NfUser nfUser;
}
