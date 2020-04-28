package com.seven.forum.dao.hzw;

import com.seven.forum.entity.hzw.*;
import org.apache.ibatis.annotations.Param;

public interface NfUserDao {

    // 查询指定用户的基本信息
    NfUserEasyEntity getUserEasyByUserId(@Param("userId") int userId);
    // 查询指定用户的信息
    NfUserEntity getUserByUserId(@Param("userId") int userId);
    // 查询管理员信息
    NfAdminEntity getNfAdminByAdminId(@Param("adminId") int adminId);
    // 查询会员信息
    NfUserVipEntity getUserVipByVipId(@Param("vipId") int vipId);
    // 查询等级信息
    NfUserGradeEntity getUserGradeByGradeId(@Param("gradeId") int gradeId);

    // 添加用户
    int insertUser(@Param("nfUser") NfUserEntity nfUser);
    // 添加会员
//    int insertVip(NfUserVipEntity nfUserVipEntity);
//    // 添加等级
//    int insertGrade(NfUserGradeEntity nfUserGradeEntity);
}
