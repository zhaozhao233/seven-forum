package com.seven.forum.entity.hzw;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NfUserVipEntity {    // 会员实体类

    private Integer vipId;              // 会员ID
    private Integer vipType;            // 会员类型
    private Integer vipGroup;           // 会员组ID
    private Timestamp vipLogonTime; // 创建时间

}
