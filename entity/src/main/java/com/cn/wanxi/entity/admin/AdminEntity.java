package com.cn.wanxi.entity.admin;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public class AdminEntity {
    private int id;
    private String login_name;
    private String password;
    private String status;

    public AdminEntity() {
    }

    public AdminEntity(int id, String login_name, String password, String status) {
        this.id = id;
        this.login_name = login_name;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", login_name='" + login_name + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
