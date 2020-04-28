package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.UserCountDao;
import com.seven.forum.entity.xm.UserCount;
import com.seven.forum.service.xm.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCountServiceImpl implements UserCountService {
    @Autowired
    private UserCountDao userCountDao;

    @Override
    //根据userId查询用户统计信息
    public UserCount getUserCountByUserId(Integer userId) {
        return userCountDao.getUserCountByUserId(userId);
    }
}
