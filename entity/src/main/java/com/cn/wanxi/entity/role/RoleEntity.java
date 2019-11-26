/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleEntity
 * Author:   Administrator
 * Date:     2019/11/19 16:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.role;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/19
 * @since 1.0.0
 */
public class RoleEntity {
    Integer id;
    String roleName;

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", role_name='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}