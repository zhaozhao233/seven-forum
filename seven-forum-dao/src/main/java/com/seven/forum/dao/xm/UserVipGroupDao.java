package com.seven.forum.dao.xm;

import com.seven.forum.entity.xm.UserVipGroup;

public interface UserVipGroupDao {
    //根据groupId查询vipGroup
    UserVipGroup getUserVipGroupByGroupId(Integer groupId);
}
