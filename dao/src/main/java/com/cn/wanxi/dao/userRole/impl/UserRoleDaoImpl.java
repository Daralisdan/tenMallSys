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
package com.cn.wanxi.dao.userRole.impl;

import com.cn.wanxi.dao.userRole.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int[] batchCarFlowInsert(String username, String roleid) {
//
        String[] split = roleid.split(",");
        String sql = null;
        int[] c = null;
        for (String i : split) {
            int roleids = Integer.parseInt(i);
            sql = " INSERT INTO wx_tab_userRole(username,role_id) VALUES ('" + username + "' , " + roleids + ")";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }

    @Override
    public int[] batchCarFlowDelete(String username ,String roleid) {
//
        String[] split = roleid.split(",");
        String sql =null;
        int[] c= null;
        for (String i : split){
            int roleids = Integer.parseInt(i);
            sql =" delete  from wx_tab_userRole where username= '"+username+"' and role_id= "+roleids+" ";
            c = jdbcTemplate.batchUpdate(sql);
            System.out.println(c.length);
        }
        return c;
    }

    @Override
    public Integer selectRoleByUsername(String username) {
        String sql = "select role_id from wx_tab_userRole where username = ?";
        Object[] args = {username};
        Integer roleId = jdbcTemplate.queryForObject(sql,args,Integer.class);
        return roleId;
    }
}