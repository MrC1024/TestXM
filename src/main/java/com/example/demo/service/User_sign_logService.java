package com.example.demo.service;

import com.example.demo.pojo.User_sign_log;

import java.util.List;

public interface User_sign_logService {
    /**
     * 添加今日签到
     */
    int addtt(User_sign_log user_sign_log);
    String selmaxDate(int user_sign_id);
    List<User_sign_log> selall(int user_sign_id);
    String sfqd(int id);
    int qd(int user_sign_id);
    int sfqd1(int user_sign_id);
    int lx(int user_sign_id,String date);
    int sfqq(int user_sign_id);
}
