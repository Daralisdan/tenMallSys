package com.cn.wanxi.entity.admin;

import com.cn.wanxi.entity.Universal;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public class AdminEntity implements Universal {
    private int id;
    private String loginName;
    private String password;
    private String status;

    public AdminEntity() {
    }

    public AdminEntity(int id, String login_name, String password, String status) {
        this.id = id;
        this.loginName = login_name;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
