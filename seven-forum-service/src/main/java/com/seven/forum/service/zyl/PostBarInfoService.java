package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;

import java.util.List;

public interface PostBarInfoService {

    List<PostBarInfoEntity> listEightPopularPostBars();

    List<PostBarInfoEntity> listPostBarsByCatalogueId(Long catalogueId, Integer pageNum, Integer pageSize);

    Integer countPostBarsByCatalogueId(Long catalogueId);

    List<PostBarInfoEntity> listPostBarsByPartitionId(Long partitionId, Integer pageNum, Integer pageSize);

    Integer countPostBarsByPartitionId(Long partitionId);

    PostBarInfoEntity getPostBarById(Long postBarId);

    Integer isExistsPostBar(Long postBarId);

}
