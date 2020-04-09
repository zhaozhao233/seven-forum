package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.AdminGroupDao;
import com.seven.forum.dao.xm.UserDao;
import com.seven.forum.dao.xm.UserGradeGroupDao;
import com.seven.forum.dao.xm.UserVipGroupDao;
import com.seven.forum.entity.xm.User;
import com.seven.forum.entity.xm.UserGradeGroup;
import com.seven.forum.service.xm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserGradeGroupDao userGradeGroupDao;
    @Autowired
    private UserVipGroupDao userVipGroupDao;
    @Autowired
    private AdminGroupDao adminGroupDao;

    //查询手机号是否被注册
    @Override
    public Integer userPhoneIsRegiste(String userPhone) {
        return userDao.userPhoneIsRegiste(userPhone);
    }
    //添加用户
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    //根据手机和密码查询用户id(判断是否登陆成功)
    public Integer isLoginSuccess(String userPhone,String userPwd){
        return userDao.isLoginSuccess(userPhone,userPwd);
    }
    //根据id查询一个用户的基本信息
    @Override
    public User getUserBaseInfoByUserId(Integer userId){
        //先查询出基本信息（三个组信息没查出来）
        User user = userDao.getUserBaseInfoByUserId(userId);
        //查询组信息
        user.getUserGrade().setUserGradeGroup(userGradeGroupDao.getUserGradeGroupByGroupId(user.getUserGrade().getGroupId()));
        user.getUserVip().setUserVipGroup(userVipGroupDao.getUserVipGroupByGroupId(user.getUserVip().getVipGroupId()));
        user.getAdmin().setAdminGroup(adminGroupDao.getAdminGroupByGroupId(user.getAdmin().getAdminGroupId()));
        return user;
    }
}
