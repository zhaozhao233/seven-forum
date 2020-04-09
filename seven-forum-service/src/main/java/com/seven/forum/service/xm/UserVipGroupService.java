package com.seven.forum.service.xm;

import com.seven.forum.entity.xm.UserVipGroup;

public interface UserVipGroupService {
    //根据groupId查询vipGroup
    UserVipGroup getUserVipGroupByGroupId(Integer groupId);
}
