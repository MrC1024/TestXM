package com.example.demo.serviceImpl;

import com.example.demo.mapper.User_signMapper;
import com.example.demo.pojo.User_sign;
import com.example.demo.service.User_signService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("User_signService")
public class User_signServiceImpl implements User_signService{
    @Resource(name="user_signMapper")
    private User_signMapper user_signMapper;
    @Override
    public int selsf(int id) {
        return user_signMapper.selsf(id);
    }

    @Override
    public int selyf(int time) {
        return user_signMapper.selyf(time);
    }

    @Override
    public int addus(User_sign user_sign) {
        return user_signMapper.addus(user_sign);
    }

    @Override
    public User_sign sel(int userid) {
        return user_signMapper.sel(userid);
    }
}
