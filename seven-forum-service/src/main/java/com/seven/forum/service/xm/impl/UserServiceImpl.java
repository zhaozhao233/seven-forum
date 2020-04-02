package com.seven.forum.service.xm.impl;

import com.seven.forum.dao.xm.UserDao;
import com.seven.forum.entity.xm.User;
import com.seven.forum.service.xm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

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
}
