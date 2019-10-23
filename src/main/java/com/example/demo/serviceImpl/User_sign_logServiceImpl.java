package com.example.demo.serviceImpl;

import com.example.demo.mapper.User_signMapper;
import com.example.demo.mapper.User_sign_logMapper;
import com.example.demo.pojo.User_sign_log;
import com.example.demo.service.User_sign_logService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("user_sign_logService")
public class User_sign_logServiceImpl implements User_sign_logService {
    @Resource(name="user_sign_logMapper")
    User_sign_logMapper user_sign_logMapper;
    @Override
    public int addtt(User_sign_log user_sign_log) {
        return user_sign_logMapper.addtt(user_sign_log);
    }

    @Override
    public String selmaxDate(int user_sign_id) {
        return user_sign_logMapper.selmaxDate(user_sign_id);
    }

    @Override
    public List<User_sign_log> selall(int user_sign_id) {
        return user_sign_logMapper.selall(user_sign_id);
}

    @Override
    public String sfqd(int id) {
        return user_sign_logMapper.sfqd(id);
    }

    @Override
    public int qd(int user_sign_id) {
        return user_sign_logMapper.qd(user_sign_id);
    }

    @Override
    public int sfqd1(int user_sign_id) {
        return user_sign_logMapper.sfqd1(user_sign_id);
    }

    @Override
    public int lx(int user_sign_id,String date) {
        return user_sign_logMapper.lx(user_sign_id,date);
    }

    @Override
    public int sfqq(int user_sign_id) {
        return user_sign_logMapper.sfqq(user_sign_id);
    }

}
