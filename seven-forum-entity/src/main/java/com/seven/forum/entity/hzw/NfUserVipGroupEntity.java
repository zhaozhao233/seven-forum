package com.seven.forum.entity.hzw;

import lombok.Data;

@Data
public class NfUserVipGroupEntity {   // 会员组权限实体类

    private int vipGroupId;     // 会员组ID
    private int createPostBar;  // 允许创建贴吧
    private int releasePost;    // 允许发帖

}
