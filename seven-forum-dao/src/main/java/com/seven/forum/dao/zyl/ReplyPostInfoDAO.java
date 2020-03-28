package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.ReplyInfoEntity;

import java.util.List;

public interface ReplyPostInfoDAO {

    Integer countReplies(Long replyPostId);

    List<ReplyInfoEntity> listRepliesByReplyPostId(Long replyPostId);
}
