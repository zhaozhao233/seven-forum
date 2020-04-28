package com.seven.forum.dao.xm;

import com.seven.forum.entity.xm.User;

public interface UserDao {
    //查询手机号是否被注册
    Integer userPhoneIsRegiste(String userPhone);
    //添加用户
    void addUser(User user);
    //根据手机和密码查询用户id(判断是否登陆成功)
    Integer isLoginSuccess(String userPhone, String userPwd);
    //根据id查询一个用户的基本信息
    User getUserBaseInfoByUserId(Integer userId);
}
