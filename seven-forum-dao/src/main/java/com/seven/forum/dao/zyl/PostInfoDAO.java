package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sun.rmi.runtime.Log;

import java.util.List;

public interface PostInfoDAO {

    List<PostInfoEntity> listAllPostInfos(Long postBarId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Long countPostInfoByPostBarId(Long postBarId);

    List<PostInfoEntity> listAllWonderfulPost(Long postBarId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Long countWonderfulPostInfoByPostBarId(Long postBarId);

    PostInfoEntity getPostInfoById(Long postId);

    Integer countPostReplies(Long postId);

    PartitionCatalogueEntity getCatalogueByPostBarId(Long postBarId);

    List<ReplyPostInfoEntity> replyPostInfos(Long postId);

    PostBarInfoEntity getPostBarByPostId(Long postId);

    List<ReplyPostInfoEntity> listPostsAndCountReply(Long postId);

    List<Long> listReplyPostIdsByPostId(Long postId);

    List<ReplyInfoEntity> listRepliesInReplyPostByPostId(List<Long> replyPostId);
}
