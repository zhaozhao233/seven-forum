package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.UserVipGroupDao;
import com.seven.forum.entity.xm.UserVipGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVipGroupServiceImpl {
    @Autowired
    private UserVipGroupDao userVipGroupDao;

    //根据groupId查询vipGroup
    public UserVipGroup getUserVipGroupByGroupId(Integer groupId){
        return userVipGroupDao.getUserVipGroupByGroupId(groupId);
    }
}
