package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.PostBarPartitionEntity;

import java.util.List;

public interface PostBarPartitionService {

    List<PostBarPartitionEntity> listAllPartitionsAndCatalogues();

    Integer isExistsPostBarPartitionByPartitionId(Long partitionId);

    Integer isExistsPartitionCatalogueByCatalogueId(Long catalogueId);
}
