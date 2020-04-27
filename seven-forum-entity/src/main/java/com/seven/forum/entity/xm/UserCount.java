package com.seven.forum.entity.xm;

import lombok.Data;

@Data
//用户统计实体
public class UserCount {
    //id
    private Integer userId;
    //关注数
    private Integer attentionCount;
    //粉丝数
    private Integer fansCount;
    //帖子数
    private Integer postCount;
    //贴吧数
    private Integer postBarCount;
    //精华帖子数
    private Integer wonderfulPostCount;
    //在线时长
    private Integer onlineTime;
    //获得点赞数
    private Integer getLike;

}
