package com.seven.forum.controller.xm;


import com.seven.forum.entity.xm.User;
import com.seven.forum.service.xm.UserService;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    //显示登陆页面
    @GetMapping("/login")
    public String enterLogin(){
        return "login";
    }

    //登陆验证
    @PostMapping("/login")
    @ResponseBody
    public ResponseVO login(String userPhone,String userPwd, HttpServletRequest req){
        Integer userId = userService.isLoginSuccess(userPhone,userPwd);
        ResponseVO responseVO =null;
        if(userId != null){
            //登陆成功
            //保存到session
            req.getSession().setAttribute("userId",userId);
            responseVO = new ResponseVO(200,"登陆成功",null);
        }else{
            responseVO = new ResponseVO(500,"手机或密码错误！",null);
        }
        return responseVO;
    }

    //注销
    @GetMapping("/loginOff")
    @ResponseBody
    public ResponseVO loginOff(HttpServletRequest req){
        //注销
        req.getSession().removeAttribute("userId");
        return new ResponseVO(200,"ok",null);
    }

//    //判断用户是否登陆
//    @GetMapping("/isLogin")
//    @ResponseBody
//    public ResponseDTO isLogin(HttpServletRequest req){
//        ResponseDTO responseDTO;
//        Object loginObj = req.getSession().getAttribute("login");
//        if(loginObj != null){
//            responseDTO = new ResponseDTO("200","用户已经登陆",loginObj);
//        }else{
//            responseDTO = new ResponseDTO("500","用户未登录",null);
//        }
//            return responseDTO;
//    }
}
