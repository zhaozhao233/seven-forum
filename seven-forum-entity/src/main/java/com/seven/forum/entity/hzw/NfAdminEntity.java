package com.seven.forum.entity.hzw;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NfAdminEntity {  // 管理员实体类

    private int adminId;                // 管理员ID
    private int adminType;              // 管理员类型
    private int adminGroupId;           // 管理组ID
    private int userId;                 // 创建者ID
    private Timestamp adminLogonTime;   // 创建时间

}
