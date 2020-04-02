package com.seven.forum.entity.hzw;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NfUserEntity {   // 用户实体类

    private Integer userId;         // 用户ID
    private String userPhone;       // 手机号
    private String userEmail;       // 邮箱
    private String userName;        // 用户昵称
    private String userImgUrl;      // 用户头像URL
    private String userPwd;         // 密码
    private Integer status;         // 用户是否已经删除
    private Integer adminId;        // 管理员ID
    private NfAdminEntity nfAdminEntity;
    private Integer gradeId;        // 等级ID
    private NfUserGradeEntity nfUserGradeEntity;
    private Integer vipId;          // 会员ID
    private NfUserVipEntity nfUserVipEntity;
    private Timestamp userLogonTime;// 注册时间
    private Integer userCoin;       // 硬币数
    private Integer userExp;        // 经验值

}
