package com.example.demo.pojo;

import java.util.List;

public class Options {
    private Integer o_id;
    private String o_name;
    private String o_countent;
    private Integer answer_id;

    private List<Answer> answers;

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public String getO_countent() {
        return o_countent;
    }

    public void setO_countent(String o_countent) {
        this.o_countent = o_countent;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
