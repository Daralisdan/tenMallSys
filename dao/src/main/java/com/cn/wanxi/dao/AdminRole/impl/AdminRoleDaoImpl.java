/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserRoleDaoImpl
 * Author:   Administrator
 * Date:     2019/11/27 9:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.AdminRole.impl;

import com.cn.wanxi.dao.AdminRole.IAdminRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@Repository
public class AdminRoleDaoImpl implements IAdminRoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int[] batchCarFlowInsert(String adminName, String roleId) {
//
        String[] split = roleId.split(",");
        String sql = null;
        int[] c = null;
        for (String i : split) {
            int roleids = Integer.parseInt(i);
            sql = " INSERT INTO wx_tab_adminRole(admin_name,role_id) VALUES ('" + adminName + "' , " + roleids + ")";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }

    @Override
    public int[] batchCarFlowDelete(String adminName ,String roleId) {
//
        String[] split = roleId.split(",");
        String sql =null;
        int[] c= null;
        for (String i : split){
            int roleids = Integer.parseInt(i);
            sql =" delete  from wx_tab_adminRole where admin_name= '"+adminName+"' and role_id= "+roleids+" ";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }

    @Override
    public Integer selectRoleByUsername(String adminName) {
        String sql = "select role_id from wx_tab_adminRole where admin_name = ?";
        Object[] args = {adminName};
        // roleId为1默认得到所有权限
        Integer roleId = 1;
        try{
            roleId = jdbcTemplate.queryForObject(sql,args,Integer.class);
        } catch (EmptyResultDataAccessException e){
            System.out.println("没有角色Id默认返回全部权限");
        }
        return roleId;
    }
}