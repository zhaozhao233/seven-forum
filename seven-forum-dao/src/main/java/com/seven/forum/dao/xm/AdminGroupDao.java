package com.seven.forum.dao.xm;

import com.seven.forum.entity.xm.AdminGroup;

public interface AdminGroupDao {
    //根据管理员组id查询管理员组
    AdminGroup getAdminGroupByGroupId(Integer groupId);
}
