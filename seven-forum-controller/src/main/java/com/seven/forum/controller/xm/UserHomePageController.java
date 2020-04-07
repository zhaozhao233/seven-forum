package com.seven.forum.controller.xm;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserHomePageController {
    //进入用户个人主页
    @GetMapping("/homepage")
    public String userHomePage(Integer userId){
        return "user/homepage/index";
    }
}
