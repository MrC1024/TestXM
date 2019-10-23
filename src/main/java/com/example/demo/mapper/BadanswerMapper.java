package com.example.demo.mapper;

import com.example.demo.pojo.Badanswer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BadanswerMapper {

    /**
     * 查询当前用户错题
     *
     * @return
     */
    //@Select("SELECT `a_name`,b.`bad_option` from `answer` AS a,`bad_answer` AS b where a.`a_id`=b.`answer_id` and b.`bad_option`!=a.`key` and b.`user_id`=#{user_id}")

    List<Badanswer> getBadanswer(@Param("user_id") String user_id, @Param("t_id") String t_id);

    /**
     * 增加错题
     */
    Integer addCuoTi(Badanswer badanswer);
}
