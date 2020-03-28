package com.seven.forum.entity.zyl;

import lombok.Data;

import java.util.Date;

@Data
public class NfUser {

    private Long userId;
    private String userPhone;
    private String userEmail;
    private String userName;
    private String userImgUrl;
    private String userPwd;
    private Integer status;
    private Long adminId;
    private Long gradeId;
    private Long vipId;
    private Date userLogonTime;
    private Long userCoin;
    private Long userExp;


}
