package com.seven.forum.entity.xm;

import lombok.Data;

@Data
public class AdminGroup {
    //管理员组id
    private Integer adminGroupId;
    //是否允许删除帖子
    private Integer allowClearPost;
    //是否允许关闭贴吧
    private Integer allowClearPostBar;
    //是否允许置顶帖子
    private Integer allowTopPost;
    //是否允许精华帖子
    private Integer allowWonderfulPost;
    //管理员组权限描述
    private String groupDesc;
}
