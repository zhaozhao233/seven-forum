package com.seven.forum.entity.zyl;

import lombok.Data;

import java.util.Date;

@Data
public class UserCollect {

    private Long collectId;
    private Long userId;
    private Long collectObjId;
    private Integer collectObjStatus;
    private Long collectGroupId;
    private Date collectTime;

}
