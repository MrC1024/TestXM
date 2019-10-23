package com.example.demo.pojo;

public class TestPaper {

    private Integer t_id;//试卷Id
    private String t_name;//试卷名称
    private Integer testpaperstep_step_id;//试卷分类
    private Integer t_grade;//成绩
    private Double t_correctness;//正确率
    private Integer user_id;//用户id

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getTestpaperstep_step_id() {
        return testpaperstep_step_id;
    }

    public void setTestpaperstep_step_id(Integer testpaperstep_step_id) {
        this.testpaperstep_step_id = testpaperstep_step_id;
    }

    public Integer getT_grade() {
        return t_grade;
    }

    public void setT_grade(Integer t_grade) {
        this.t_grade = t_grade;
    }

    public Double getT_correctness() {
        return t_correctness;
    }

    public void setT_correctness(Double t_correctness) {
        this.t_correctness = t_correctness;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
