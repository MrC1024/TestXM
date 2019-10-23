package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.*;
import com.example.demo.service.BadanwerService;
import com.example.demo.service.TestpaperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestpaperController {

    @Autowired
    TestpaperService testpaperService;

    @Autowired
    BadanwerService badanwerService;

    /**
     * 查询全部试卷
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<TestPaper> getAll() {
        return testpaperService.getAll();
    }


    /**
     * 查询当前用户错题
     *
     * @param user_id
     * @return
     */
    @GetMapping("/getBad")
    public List<Badanswer> getBadanswer(String user_id, String t_id) {
        return badanwerService.getBadanswer(user_id, t_id);
    }


    /**
     * 开始考试
     *
     * @param testpaper_id
     * @return
     */
    @GetMapping("/doTest")
    public List<Answer> doTest(String testpaper_id) {
        return testpaperService.doTest(testpaper_id);

    }

    @GetMapping("/findT")
    public Integer findT(@Param("a_id") Integer a_id, @Param("key") String key) {
        return testpaperService.findT(a_id, key);
    }


    /**
     * 查找选项
     *
     * @param answer_id
     * @return
     */
    @GetMapping("/doOptions")
    public List<Options> doOptions(@Param("answer_id") String answer_id) {
        return testpaperService.doOptions(answer_id);
    }


    /**
     * 查找试卷分类
     *
     * @return
     */
    @GetMapping("/getStep")
    public List<TestpaperStep> getStep() {
        return testpaperService.getStep();
    }

}
