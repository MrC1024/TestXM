package com.example.demo.pojo;

public class User_sign_log {
    private int id;
    private String create_time;
    private String sign_status;
    private String update_time;
    private int user_sign_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSign_status() {
        return sign_status;
    }

    public void setSign_status(String sign_status) {
        this.sign_status = sign_status;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getUser_sign_id() {
        return user_sign_id;
    }

    public void setUser_sign_id(int user_sign_id) {
        this.user_sign_id = user_sign_id;
    }
}
