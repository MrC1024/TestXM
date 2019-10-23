package com.example.demo.serviceImpl;

import com.example.demo.mapper.BadanswerMapper;
import com.example.demo.pojo.Badanswer;
import com.example.demo.service.BadanwerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadanswerServiceImpl implements BadanwerService {

    @Autowired
    BadanswerMapper badanswerMapper;


    /**
     * 查询当前用户错题
     *
     * @return
     */
    @Override
    public List<Badanswer> getBadanswer(String user_id, String t_id) {
        return badanswerMapper.getBadanswer(user_id, t_id);
    }

    @Override
    public Integer addCuoTi(Badanswer badanswer) {
        return badanswerMapper.addCuoTi(badanswer);
    }
}
