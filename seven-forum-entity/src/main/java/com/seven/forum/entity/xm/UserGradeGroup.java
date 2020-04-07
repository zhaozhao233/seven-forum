package com.seven.forum.entity.xm;

import lombok.Data;

@Data
public class UserGradeGroup {

    //等级组id
    private Integer gradeGroupId;
    //是否允许发表评论
    private Integer allowComment;
    //是否允许发帖
    private Integer releasePost;


}
