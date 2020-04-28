package com.seven.forum.entity.hzw;

import lombok.Data;

@Data
public class NfUserGradeEntity {  // 等级实体类

    private int gradeId;        // 等级ID
    private String gradeType;   // 等级类型
    private int gradeGroupId;   // 等级组ID
    private String title;       // 头衔
    private int nextGradeExp;   // 下一级所需经验

}
