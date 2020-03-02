package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.PostBarPartitionEntity;

import java.util.List;

public interface PostBarPartitionDao {

    List<PostBarPartitionEntity> listAllPartitionsAndCatalogues();
}
