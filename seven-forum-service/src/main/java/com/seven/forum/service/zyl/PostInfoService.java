package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostInfoService {

    List<PostInfoEntity> listAllPostInfos(Long postBarId, Integer pageNum, Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

    PostInfoEntity getPostInfoById(Long postId);

    Integer countPostReplies(Long postId);

    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

    List<ReplyPostInfoEntity> replyPostInfos(Long postId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId);

    List<ReplyInfoEntity> listRepliesByPostId(Long postId);
}
