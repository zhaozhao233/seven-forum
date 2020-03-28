package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostInfoDAO;
import com.seven.forum.entity.zyl.*;
import com.seven.forum.service.zyl.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostInfoServiceImpl implements PostInfoService {
    @Autowired
    private PostInfoDAO postInfoDAO;
    @Override
    public List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllPostInfos(postBarId, pageNum, pageSize);
    }

    @Override
    public Long countPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countPostInfoByPostBarId(postBarId);
    }

    @Override
    public List<PostInfoEntity> listAllWonderfulPost(Long postBarId, Integer pageNum, Integer pageSize) {
        return postInfoDAO.listAllWonderfulPost(postBarId, pageNum, pageSize);
    }

    @Override
    public Long countWonderfulPostInfoByPostBarId(Long postBarId) {
        return postInfoDAO.countWonderfulPostInfoByPostBarId(postBarId);
    }

    @Override
    public PostInfoEntity getPostInfoById(Long postId) {
        return postInfoDAO.getPostInfoById(postId);
    }

    @Override
    public Integer countPostReplies(Long postId) {
        return postInfoDAO.countPostReplies(postId);
    }

    @Override
    public PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId) {
        return postInfoDAO.getCatalogueByPostBarId(postBarId);
    }

    @Override
    public List<ReplyPostInfoEntity> replyPostInfos(Long postId) {
        return postInfoDAO.replyPostInfos(postId);
    }

    @Override
    public PostBarInfoEntity getPostBarByPostId(Long postId) {
        return postInfoDAO.getPostBarByPostId(postId);
    }

    @Override
    public List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId) {
        return postInfoDAO.listPostsAndCountReply(postId);
    }

    @Override
    public List<ReplyInfoEntity> listRepliesByPostId(Long postId) {
        List<Long> replyPostIds = postInfoDAO.listReplyPostIdsByPostId(postId);
        List<ReplyInfoEntity> replyInfoEntities = postInfoDAO.listRepliesInReplyPostByPostId(replyPostIds);
        return replyInfoEntities;
    }
}
