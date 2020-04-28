package com.seven.forum.service.hzw.impl;

import com.seven.forum.dao.hzw.NfUserDao;
import com.seven.forum.entity.hzw.*;
import com.seven.forum.service.hzw.NfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NfUserServiceImpl implements NfUserService {

    @Autowired
    private NfUserDao nfUserDao;


    @Override
    public NfUserEasyEntity getUserEasyByUserId(int userId) {
        return nfUserDao.getUserEasyByUserId(userId);
    }

    @Override
    public NfUserEntity getUserByUserId(int userId) {
        return nfUserDao.getUserByUserId(userId);
    }

    @Override
    public NfAdminEntity getNfAdminByAdminId(int adminId) {
        return nfUserDao.getNfAdminByAdminId(adminId);
    }

    @Override
    public NfUserVipEntity getUserVipByVipId(int vipId) {
        return nfUserDao.getUserVipByVipId(vipId);
    }

    @Override
    public NfUserGradeEntity getUserGradeByGradeId(int gradeId) {
        return nfUserDao.getUserGradeByGradeId(gradeId);
    }


    // insert
    @Override
    public int insertUser(NfUserEntity nfUser) {
        return nfUserDao.insertUser(nfUser);
    }
}
