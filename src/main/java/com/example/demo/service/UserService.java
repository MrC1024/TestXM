package com.example.demo.service;


import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    Integer Login(String account, String password);

    User getMessage(String account);
    /**
     * 修改密码
     */
    Integer xiugai(User user);
    Integer xiugai1(int id,String userName);
}
