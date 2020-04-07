package com.seven.forum.entity.xm;

import lombok.Data;

@Data
public class UserGrade {
    //等级id
    private Integer gradeId;
    //等级组id
    private Integer groupId;
    //头衔
    private String title;
    //下一级所需经验
    private Integer nextGradeExp;

    //关联一个等级组实体
    private UserGradeGroup userGradeGroup;
}
