package com.example.demo.service;

import com.example.demo.pojo.Answer;
import com.example.demo.pojo.Options;
import com.example.demo.pojo.TestPaper;
import com.example.demo.pojo.TestpaperStep;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TestpaperService {

    /**
     * 查询全部试卷
     *
     * @return
     */
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
     * 查找试卷分类
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
