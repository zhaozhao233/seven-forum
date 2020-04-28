package com.seven.forum.service.xm;

import com.seven.forum.entity.xm.UserGradeGroup;

public interface UserGradeGroupService {
    //根据等级组id查询等级组
    UserGradeGroup getUserGradeGroupByGroupId(Integer groupId);
}
