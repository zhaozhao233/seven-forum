package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.AdminGroupDao;
import com.seven.forum.entity.xm.AdminGroup;
import com.seven.forum.service.xm.AdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminGroupServiceImpl implements AdminGroupService {
    @Autowired
    private AdminGroupDao adminGroupDao;

    @Override
    //根据管理员组id查询管理员组
    public AdminGroup getAdminGroupByGroupId(Integer groupId){
        return adminGroupDao.getAdminGroupByGroupId(groupId);
    }
}
