package com.example.demo.mapper;

import com.example.demo.pojo.UserSignLog;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2019/5/9 14:55
 */

public interface UserSignLogMapper{


    int updateUserSignLogSignStatus(Long userSignId);


    List<UserSignLog> findUserSignLogsByUserSignIdAndSignStatusIsTrue(Long userSignId);


}

