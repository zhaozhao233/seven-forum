package com.seven.forum.service.xm;

import com.seven.forum.entity.xm.AdminGroup;

public interface AdminGroupService {
    //根据管理员组id查询管理员组
    AdminGroup getAdminGroupByGroupId(Integer groupId);
}
