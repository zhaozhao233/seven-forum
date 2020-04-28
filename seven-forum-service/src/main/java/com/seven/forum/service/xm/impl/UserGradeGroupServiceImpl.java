package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.UserGradeGroupDao;
import com.seven.forum.entity.xm.UserGradeGroup;
import com.seven.forum.service.xm.UserGradeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGradeGroupServiceImpl implements UserGradeGroupService {
    @Autowired
    private UserGradeGroupDao userGradeGroupDao;

    @Override
    //根据等级组id查询等级组
    public UserGradeGroup getUserGradeGroupByGroupId(Integer groupId){
        return userGradeGroupDao.getUserGradeGroupByGroupId(groupId);
    }
}
