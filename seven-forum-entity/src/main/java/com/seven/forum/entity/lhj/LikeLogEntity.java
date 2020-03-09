package com.seven.forum.entity.lhj;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LikeLogEntity {//点赞记录

    private Integer likeLogId;
    private Integer likeType;
    private Integer likeObjId;
    private Integer userId;
    private Integer likeStatus;
    private Timestamp likeTime;
}