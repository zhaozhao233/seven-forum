package com.seven.forum.service.xm;

import com.seven.forum.entity.xm.User;

public interface UserService {
    //查询手机号是否被注册
    Integer userPhoneIsRegiste(String userPhone);
    //添加用户
    void addUser(User user);
    //根据手机和密码查询用户id(判断是否登陆成功)
    Integer isLoginSuccess(String userPhone, String userPwd);
}
