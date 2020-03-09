package com.seven.forum.entity.lhj;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDynamicEntity {//用户动态
    private Integer DynamicId;
    private Integer userId;
    private String dynamicContent;
    private Integer dynamicStatus;
    private Timestamp dynamicTime;
    private Integer likeCount;
    private Integer commentCount;
}
