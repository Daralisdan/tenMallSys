package com.cn.wanxi.dao.admin.impl;

import com.cn.wanxi.dao.admin.IAdminDao;
import com.cn.wanxi.entity.admin.AdminEntity;
import com.cn.wanxi.utils.jdbcTemplateSentence.SQLSentence;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【登陆认证】
 * 数据表： 系统数据库wx_tab_admin 表（管理员表）
 *
 * 2019/11/18,Create by yaodan
 */
@Repository
public class AdminDaoImp implements IAdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SQLSentence sqlSentence = SQLSentence.getInstance();

    @Override
    public int insert(AdminEntity entity) {
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.INSERT);
        int counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        return counter;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_admin WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_admin";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public AdminEntity findById(int id) {
        AdminEntity adminEntity = null;
        String exeSQL = "select * from wx_tab_admin where id=?";
        List<AdminEntity> adminEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<AdminEntity>(AdminEntity.class));
        if (null != adminEntities && adminEntities.size() > 0) {
            adminEntity = adminEntities.get(0);
        }
        return adminEntity;
    }

    @Override
    public AdminEntity findByName(String login_name) {
        AdminEntity adminEntity = null;
        String exeSQL = "select * from wx_tab_admin where login_name=?";
        List<AdminEntity> adminEntities = jdbcTemplate.query(exeSQL, new Object[]{login_name}, new BeanPropertyRowMapper<AdminEntity>(AdminEntity.class));
        if (null != adminEntities && adminEntities.size() > 0) {
            adminEntity = adminEntities.get(0);
        }
        return adminEntity;
    }

    @Override
    public int update(AdminEntity entity) {
        String exeSQL = "update wx_tab_admin set login_name=?,password=?,status=?  WHERE id=?";
        Object args[] = {entity.getLoginName(),entity.getPassword(),entity.getStatus(),entity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }
}
