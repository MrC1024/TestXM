package com.example.demo.pojo;

public class Badanswer {
    private Integer bad_id;//错题Id
    private Integer answer_id;//题库Id
    private Integer user_id;//用户Id
    private String bad_option;//用户错误选择id
    private Answer answer;

    public Integer getBad_id() {
        return bad_id;
    }

    public void setBad_id(Integer bad_id) {
        this.bad_id = bad_id;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBad_option() {
        return bad_option;
    }

    public void setBad_option(String bad_option) {
        this.bad_option = bad_option;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
