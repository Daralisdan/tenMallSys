/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuEntity
 * Author:   Administrator
 * Date:     2019/11/19 17:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.roleMenu;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/19
 * @since 1.0.0
 */
public class RoleMenuEntity {
    Integer id;
    Integer role_id;
    Integer menu_id;

    @Override
    public String toString() {
        return "RoleMenuEntity{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", menu_id=" + menu_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }
}