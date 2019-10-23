package com.example.demo.pojo;
import groovy.transform.builder.Builder;

import java.util.Date;

public class UserSign {
    private Long id;

    /**
     * 关联用户ID
     */
    private Long userId;


    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 最后签到时间
     */
    private Date lastModifyTime;


    /**
     * 连续签到次数
     */
    private Integer signCount;

    /**
     * 签到次数
     */
    private Integer count;


}
