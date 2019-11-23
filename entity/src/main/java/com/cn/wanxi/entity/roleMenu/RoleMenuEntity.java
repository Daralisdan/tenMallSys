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
    Integer roleid;
    Integer menuid;

    public RoleMenuEntity() {
    }

    public RoleMenuEntity(Integer id, Integer role_id, Integer menu_id) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "RoleMenuEntity{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", menuid=" + menuid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}