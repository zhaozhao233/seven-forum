package com.seven.forum.entity.xm;

import lombok.Data;

import java.util.Date;

@Data
//会员信息
public class UserVip {
    //会员id
    private Integer vipId;
    //会员组id
    private Integer vipGroupId;
    //创建时间
    private Date vipLogonTime;

    //关联一个vip组表实体
    private UserVipGroup userVipGroup;
}
