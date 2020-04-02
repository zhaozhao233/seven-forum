package com.seven.forum.service.hzw;

import com.seven.forum.entity.hzw.*;
import org.springframework.stereotype.Service;

@Service
public interface NfUserService {

    // 查询指定用户的基本信息
    NfUserEasyEntity getUserEasyByUserId(int userId);
    // 查询指定用户的信息
    NfUserEntity getUserByUserId(int userId);
    // 查询管理员信息
    NfAdminEntity getNfAdminByAdminId(int adminId);
    // 查询会员信息
    NfUserVipEntity getUserVipByVipId(int vipId);
    // 查询等级信息
    NfUserGradeEntity getUserGradeByGradeId(int gradeId);


    // 添加用户
    int insertUser(NfUserEntity nfUser);
}
