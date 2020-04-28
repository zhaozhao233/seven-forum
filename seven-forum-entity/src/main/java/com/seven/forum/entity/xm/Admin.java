package com.seven.forum.entity.xm;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {
    //管理员id
    private Integer adminId;
    //管理组id
    private Integer adminGroupId;
    //创建者id
    private Integer userId;
    //创建时间
    private Date adminLogonTime;

    //关联一个管理员组信息实体
    private AdminGroup adminGroup;
}
