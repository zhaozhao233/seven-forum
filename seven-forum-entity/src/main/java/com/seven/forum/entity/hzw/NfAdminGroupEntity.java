package com.seven.forum.entity.hzw;

import lombok.Data;

@Data
public class NfAdminGroupEntity { // 管理组权限实体类

    private int adminGroupId;       // 管理组ID
    private int allowClearPost;     // 是否允许删除帖子
    private int allowClearPostBar;  // 是否允许关闭贴吧
    private int allowTopPost;       // 是否允许置顶帖子
    private int allowWonderfulPost; // 是否允许精华帖子

}
