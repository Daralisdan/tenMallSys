package com.cn.wanxi.service.admin;

import com.cn.wanxi.entity.admin.AdminEntity;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IAdminService {
    boolean login(String username,String password);
    boolean logout(String login_name);
}
