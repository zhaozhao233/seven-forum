package com.seven.forum.controller.xm;


import com.seven.forum.entity.xm.User;
import com.seven.forum.service.xm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserHomePageController {
    @Autowired
    private UserService userService;

    //进入用户个人主页
    @GetMapping("/homepage")
    public String userHomePage(Integer userId){
        return "user/homepage/index";
    }
    //根据id查询用户基本信息
    @GetMapping("/userBaseInfo")
    @ResponseBody
    public User userBaseInfo(Integer userId){
        User user = userService.getUserBaseInfoByUserId(userId);
        return user;
    }
}
