package com.example.demo.mapper;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int register(User user);
    User getMessage(String account);
    Integer xiugai(User user);
    Integer Login(@Param("account") String account, @Param("password")String password);//登陆
    Integer xiugai1(@Param("id") int id,@Param("userName")String userName);
}
