package com.example.demo.pojo;

import java.util.Date;

/**
 * 描述：用户签到记录表
 *
 * @author 哈哈哈
 * @date 2019/5/9 14:52
 */
public class UserSignLog {
    private Long id;


    /**
     * 关联签到id
     */
    private Long userSignId;


    private Date createTime;

    private Date updateTime;


    /**
     * 是否可用
     */
    private Boolean signStatus;

}

