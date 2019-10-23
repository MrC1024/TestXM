package com.example.demo.service;

import com.example.demo.pojo.User_sign;

public interface User_signService {
    /**
     * 查询是否有签到数据
     */
    int selsf(int id);
    int selyf(int time);
    /**
     *
     * 添加用户
     *
     */
    int addus(User_sign user_sign);
    User_sign sel(int userid);
}
