package com.example.demo.pojo;

import java.util.List;

public class Answer {

    private Integer a_id;//题库Id
    private String a_name;//题目答案
    private Integer testpaped_id;//试卷Id
    private String key;//答案
    private String resolv;//解析

    private List<Badanswer> badanswers;


    private Options options;

    private Integer a_option_num;

    public List<Badanswer> getBadanswers() {
        return badanswers;
    }

    public void setBadanswers(List<Badanswer> badanswers) {
        this.badanswers = badanswers;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public Integer getTestpaped_id() {
        return testpaped_id;
    }

    public void setTestpaped_id(Integer testpaped_id) {
        this.testpaped_id = testpaped_id;
    }

    public String getResolv() {
        return resolv;
    }

    public void setResolv(String resolv) {
        this.resolv = resolv;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Integer getA_option_num() {
        return a_option_num;
    }

    public void setA_option_num(Integer a_option_num) {
        this.a_option_num = a_option_num;
    }

}
