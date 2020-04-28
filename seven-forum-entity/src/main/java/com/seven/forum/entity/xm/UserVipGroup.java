package com.seven.forum.entity.xm;

import lombok.Data;

@Data
//会员组信息实体
public class UserVipGroup {
    //会员组id
    private Integer vipGroupId;
    //是否允许创建贴吧
    private Integer createPostBar;
    //会员组权限描述
    private String groupDesc;
}
