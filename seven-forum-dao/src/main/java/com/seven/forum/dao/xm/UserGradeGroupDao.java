package com.seven.forum.dao.xm;


import com.seven.forum.entity.xm.UserGradeGroup;

public interface UserGradeGroupDao {
    //根据等级组id查询等级组
    UserGradeGroup getUserGradeGroupByGroupId(Integer groupId);
}
