package com.seven.forum.dao.xm;

import com.seven.forum.entity.xm.UserCount;

public interface UserCountDao {
    //根据userId查询用户统计信息
    UserCount getUserCountByUserId(Integer userId);
}
