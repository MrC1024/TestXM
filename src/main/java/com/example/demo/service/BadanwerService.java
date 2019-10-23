package com.example.demo.service;

import com.example.demo.pojo.Badanswer;

import java.util.List;

public interface BadanwerService {

    /**
     * 查询当前用户错题
     *
     * @return
     */
    public List<Badanswer> getBadanswer(String user_id, String t_id);

    /**
     * 增加错题
     */
    Integer addCuoTi(Badanswer badanswer);
}
