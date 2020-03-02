package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostBarPartitionDao;
import com.seven.forum.entity.zyl.PostBarPartitionEntity;
import com.seven.forum.service.zyl.PostBarPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostBarPartitionServiceImpl implements PostBarPartitionService {
    @Autowired
    private PostBarPartitionDao postBarPartitionDao;
    @Override
    public List<PostBarPartitionEntity> listAllPartitionsAndCatalogues() {
        return postBarPartitionDao.listAllPartitionsAndCatalogues();
    }
}
