package com.example.demo.mapper;

import com.example.demo.pojo.User_sign_log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_sign_logMapper {
    /**
     * 添加今日签到
     */
    int addtt(User_sign_log user_sign_log);
    String selmaxDate(int user_sign_id);
    List<User_sign_log> selall(int user_sign_id);
    String sfqd(int id);
    int qd(int user_sign_id);
    int sfqd1(int user_sign_id);
    int lx(@Param("user_sign_id") int user_sign_id,@Param("date") String date);
    int sfqq(int user_sign_id);
}
