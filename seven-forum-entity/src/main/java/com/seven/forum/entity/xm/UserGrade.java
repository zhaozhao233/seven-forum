package com.seven.forum.entity.xm;

import lombok.Data;

@Data
public class UserGrade {
    //等级id
    private Integer gradeId;
    //等级数
    private Integer gradeNumber;
    //等级组id
    private Integer groupId;
    //下一级所需经验
    private Integer nextGradeExp;

    //关联一个等级组实体
    private UserGradeGroup userGradeGroup;
}
