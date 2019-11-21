package com.cn.wanxi.utils.Test;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Date date;

    public User() {
    }

    public User(Integer id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
