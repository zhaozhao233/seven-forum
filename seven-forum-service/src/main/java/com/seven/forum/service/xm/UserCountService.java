package com.seven.forum.service.xm;

import com.seven.forum.entity.xm.UserCount;

public interface UserCountService {
    //根据userId查询用户统计信息
    UserCount getUserCountByUserId(Integer userId);
}
