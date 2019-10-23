package com.example.demo.serviceImpl;

import com.example.demo.mapper.TestpaperMapper;
import com.example.demo.pojo.Answer;
import com.example.demo.pojo.Options;
import com.example.demo.pojo.TestPaper;
import com.example.demo.pojo.TestpaperStep;
import com.example.demo.service.TestpaperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestpaperServiecImpl implements TestpaperService {

    @Autowired
    TestpaperMapper testpaperMapper;

    /**
     * 查询全部试卷
     *
     * @return
     */
    @Override
    public List<TestPaper> getAll() {
        return testpaperMapper.getAll();
    }

    @Override
    public List<Answer> doTest(String testpaper_id) {
        return testpaperMapper.doTest(testpaper_id);
    }

    @Override
    public Integer findT(@Param("a_id") Integer a_id, @Param("key") String key) {
        return testpaperMapper.findT(a_id, key);
    }

    @Override
    public List<Options> doOptions(@Param("answer_id") String answer_id) {
        return testpaperMapper.doOptions(answer_id);
    }

    @Override
    public List<TestpaperStep> getStep() {
        return testpaperMapper.getStep();
    }

    @Override
    public Integer addTest(TestPaper testPaper) {
        return testpaperMapper.addTest(testPaper);
    }

    @Override
    public TestpaperStep getTest(Integer testpaper_step_id) {
        return testpaperMapper.getTest(testpaper_step_id);
    }

}
