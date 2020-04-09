package com.seven.forum.controller.xm;


import com.seven.forum.entity.xm.User;
import com.seven.forum.service.xm.UserService;
import com.seven.forum.util.SendSmsUtil;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/registe")
public class RegisteController {

    @Autowired
    private UserService userService;
    //验证码
    private static String checkCode;

    //进入注册页面
    @GetMapping("/index")
    public String index(){
        return "registe";
    }

    //查询手机号是否注册
    @GetMapping("/userPhoneIsRegiste")
    @ResponseBody
    public ResponseVO userPhoneIsRegiste(String phoneNumber){
        ResponseVO responseVO;
        Integer count = userService.userPhoneIsRegiste(phoneNumber);
        if(count==0){
            responseVO = new ResponseVO(200,"手机号未被注册",null);
        }else{
            responseVO = new ResponseVO(500,"手机号已被注册",null);
        }
        return responseVO;
    }

    @GetMapping("/code")
    @ResponseBody
    //发送短信验证码
    public ResponseVO sendCode(String phoneNumber){
        checkCode = SendSmsUtil.sendSms(phoneNumber);
        ResponseVO responseDTO = new ResponseVO(200,"发送短信成功!",null);
        return responseDTO;
    }

    //验证短信验证码
    @PostMapping("/checkCode")
    @ResponseBody
    //发送短信验证码
    public ResponseVO checkCode(String code){
        ResponseVO responseVO;
        if(checkCode.equals(code)){
            responseVO = new ResponseVO(200,"发送短信成功!",null);
        }else{
            responseVO = new ResponseVO(500,"验证码错误!",null);
        }
        return responseVO;
    }

    @PostMapping("/registeUser")
    @ResponseBody
    //注册用户
    public ResponseVO checkCode(@RequestBody User user){
        //注册
        User userInfo = user;
        //默认用户昵称
        userInfo.setUserName("未命名");
        //默认选择一张头像
        user.setUserImgUrl("default.jpg");
        //注册时间
        user.setUserLogonTime(new Date());
        userService.addUser(user);
        ResponseVO responseVO = new ResponseVO(200,"用户注册成功",new String("成功"));
        return responseVO;
    }
}
