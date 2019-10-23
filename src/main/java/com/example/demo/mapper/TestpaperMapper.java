package com.example.demo.mapper;

import com.example.demo.pojo.Answer;
import com.example.demo.pojo.Options;
import com.example.demo.pojo.TestPaper;

import com.example.demo.pojo.TestpaperStep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestpaperMapper {

    /**
     * 查询全部试卷
     *
     * @return
     */
    @Select("SELECT * FROM `testpaper`;")
    public List<TestPaper> getAll();

    /**
     * 开始考试
     *
     * @param testpaper_id
     * @return
     */
    public List<Answer> doTest(String testpaper_id);


    public Integer findT(@Param("a_id") Integer a_id, @Param("key") String key);


    /**
     * 查找选项
     *
     * @param answer_id
     * @return
     */
    public List<Options> doOptions(@Param("answer_id") String answer_id);


    /**
     * 查询分类
     *
     * @return
     */
    public List<TestpaperStep> getStep();
    /**
     * 增加试卷
     */
    Integer addTest(TestPaper testPaper);
    /**
     * 根据stepid查询信息
     */
    TestpaperStep getTest(Integer testpaper_step_id);

}
