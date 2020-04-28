package com.seven.forum.entity.hzw;

import lombok.Data;

@Data
public class NfUserEasyEntity {   // 用户简单信息表

    private int userId;         // 用户ID
    private String userName;    // 用户昵称
    private String userImgUrl;  // 用户头像URL
    private int adminId;        // 管理员ID
    private int gradeId;        // 等级ID
    private int vipId;          // 会员ID
}
