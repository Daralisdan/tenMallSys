/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserRoleEntity
 * Author:   Administrator
 * Date:     2019/11/27 9:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.userRole;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
public class UserRoleEntity {
    private Integer id;
    private String username;
    private Integer roleId;

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}