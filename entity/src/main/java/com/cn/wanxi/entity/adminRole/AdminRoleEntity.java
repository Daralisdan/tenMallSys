/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AdminRoleEntity
 * Author:   Administrator
 * Date:     2019/11/27 9:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.adminRole;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */

/**
 * 2019年12月5日16:18:40
 * 将UserRoleEntity换为AdminRoleEntity排除歧义
 */
public class AdminRoleEntity {
    private Integer id;
    private String adminName;
    private Integer roleId;

    public AdminRoleEntity() {
    }

    public AdminRoleEntity(Integer id, String adminName, Integer roleId) {
        this.id = id;
        this.adminName = adminName;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRoleEntity{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}