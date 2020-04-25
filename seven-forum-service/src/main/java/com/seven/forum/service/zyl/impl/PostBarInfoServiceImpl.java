package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostBarInfoDAO;
import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.service.zyl.PostBarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostBarInfoServiceImpl implements PostBarInfoService {
    @Autowired
    private PostBarInfoDAO postBarInfoDAO;

    /**
     * 实际上选的是前8个人数多的贴吧
     * 并没有从前100里面“随机”选8个，就只是前8个了
     * 要改的话就直接nextInt(8) --》nextInt(100)
     * 主要是贴吧没100个状态正常的就会报错
     * @return
     */
    @Override
    public List<PostBarInfoEntity> listEightPopularPostBars() {
        List<Integer> list = postBarInfoDAO.listPopularPostBarIds();
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 8) {
            int number = random.nextInt(8);
            set.add(list.get(number));
        }
        return postBarInfoDAO.listPopularPostBars(set);
    }

    @Override
    public List<PostBarInfoEntity> listPostBarsByCatalogueId(Long catalogueId, Integer pageNum, Integer pageSize) {
        return postBarInfoDAO.listPostBarsByCatalogueId(catalogueId, pageNum, pageSize);
    }

    @Override
    public Integer countPostBarsByCatalogueId(Long catalogueId) {
        return postBarInfoDAO.countPostBarsByCatalogueId(catalogueId);
    }

    @Override
    public List<PostBarInfoEntity> listPostBarsByPartitionId(Long partitionId, Integer pageNum, Integer pageSize) {
        return postBarInfoDAO.listPostBarsByPartitionId(partitionId, pageNum, pageSize);
    }

    @Override
    public Integer countPostBarsByPartitionId(Long partitionId) {
        return postBarInfoDAO.countPostBarsByPartitionId(partitionId);
    }

    @Override
    public PostBarInfoEntity getPostBarById(Long postBarId) {
        return postBarInfoDAO.getPostBarById(postBarId);
    }

    @Override
    public Integer isExistsPostBar(Long postBarId) {
        return postBarInfoDAO.isExistsPostBar(postBarId);
    }

}
