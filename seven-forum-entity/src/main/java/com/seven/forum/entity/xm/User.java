package com.seven.forum.entity.xm;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    //id
    private Integer userId;
    //手机号
    private String userPhone;
    //邮箱
    private String userEmail;
    //用户昵称
    private String userName;
    //头像
    private String userImgUrl;
    //密码
    private String userPwd;
    //状态，1存在，0被删除，默认1
    private Integer status;
    //管理员ID
    private Integer adminId;
    //等级ID
    private Integer gradeId;
    //会员ID
    private Integer vipId;
    //注册时间
    private Date userLogonTime;
    //硬币
    private Integer userCoin;
    //经验值
    private Integer userExp;
}
