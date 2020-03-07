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

    @Override
    public List<PostBarInfoEntity> listEightPopularPostBar() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 8) {
            int number = random.nextInt(100);
            set.add(number);
        }
        return postBarInfoDAO.listPopularPostBar(set);
    }
}
