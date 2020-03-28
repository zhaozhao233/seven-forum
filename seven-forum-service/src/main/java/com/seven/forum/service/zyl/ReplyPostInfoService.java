package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.ReplyInfoEntity;

import java.util.List;

public interface ReplyPostInfoService {

    Integer countReplies(Long replyPostId);

    List<ReplyInfoEntity> listRepliesByReplyPostId(Long replyPostId);
}
