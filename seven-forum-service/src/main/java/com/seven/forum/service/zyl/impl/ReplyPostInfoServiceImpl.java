package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.ReplyPostInfoDAO;
import com.seven.forum.entity.zyl.ReplyInfoEntity;
import com.seven.forum.service.zyl.ReplyPostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyPostInfoServiceImpl implements ReplyPostInfoService {
    @Autowired
    private ReplyPostInfoDAO replyPostInfoDAO;

    @Override
    public Integer countReplies(Long replyPostId) {
        return replyPostInfoDAO.countReplies(replyPostId);
    }

    @Override
    public List<ReplyInfoEntity> listRepliesByReplyPostId(Long replyPostId) {
        return replyPostInfoDAO.listRepliesByReplyPostId(replyPostId);
    }
}
