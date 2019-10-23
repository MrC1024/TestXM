package com.example.demo.serviceImpl;


import com.example.demo.mapper.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class Userserviceimpl  implements UserService{
    @Resource(name="userDao")
    private UserDao userDao;
    public Integer Login(String account, String password){
        return userDao.Login(account,password);
    }
    @Override
    public User getMessage(String account) {
        return userDao.getMessage(account);
    }
    @Override
    public Integer xiugai(User user) {
        return userDao.xiugai(user);
    }

    @Override
    public Integer xiugai1(int id,String userName) {
        return userDao.xiugai1(id,userName);
    }
}
