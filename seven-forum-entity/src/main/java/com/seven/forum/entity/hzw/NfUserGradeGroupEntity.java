package com.seven.forum.entity.hzw;

import lombok.Data;

@Data
public class NfUserGradeGroupEntity { // 等级组权限实体类

    private int gradeGroupId;   // 等级组ID
    private int allowComment;   // 是否允许发表评论

}
