package com.seven.forum.controller.xm;


import com.seven.forum.entity.xm.User;
import com.seven.forum.entity.xm.UserCount;
import com.seven.forum.service.xm.UserCountService;
import com.seven.forum.service.xm.UserService;
import com.seven.forum.vo.ResponseVO;
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
    @Autowired
    private UserCountService userCountService;

    //进入用户个人主页
//    @GetMapping("/homepage")
//    public String userHomePage(Integer userId){
//        return "user/homepage/index";
//    }
    //根据id查询用户基本信息
    @GetMapping("/userBaseInfo")
    @ResponseBody
    public ResponseVO userBaseInfo(Integer userId){
        User user = userService.getUserBaseInfoByUserId(userId);
        return new ResponseVO(200,"ok",user);
    }
    //根据userId查询统计信息
    @GetMapping("/userCount")
    @ResponseBody
    public ResponseVO userCount(Integer userId){
        UserCount userCount = userCountService.getUserCountByUserId(userId);
        return new ResponseVO(200,"ok",userCount);
    }

}
