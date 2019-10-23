package com.example.demo.mapper;

import com.example.demo.pojo.User_sign;
import org.apache.ibatis.annotations.Param;

public interface User_signMapper {
    /**
     * 查询是否有签到数据
     */
    int selsf(int id);
    int selyf(int time);
    int addus(User_sign user_sign);
    User_sign sel(int userid);
}
