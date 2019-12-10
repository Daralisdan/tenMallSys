package com.cn.wanxi.dao.menu.impl;

import com.cn.wanxi.dao.menu.IMenuDao;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.MenuTreeNodeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by zhoushiling
 */
@Slf4j
@Repository
public class MenuDaoImpl implements IMenuDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加菜单信息
     *
     * @param menu
     * @return
     */
    @Override
    public int insert(MenuEntity menu) {
        String exeSQL = "INSERT INTO wx_tab_menu(name,icon,url,parent_id) VALUES(?,?,?,?)";
        Object args[] = {menu.getName(), menu.getIcon(), menu.getUrl(), menu.getParentId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 【展示所有菜单信息】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id, name, icon, url, parent_id as parentId from wx_tab_menu";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    /**
     * 【根据id查询菜单信息】
     *
     * @param
     */
    @Override
    public MenuEntity findById(int id) {
        MenuEntity menuEntity = null;
        String exeSQL = "select id, name, icon, url, parent_id as parentId from wx_tab_menu where id=?";
        List<MenuEntity> menuEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<MenuEntity>(MenuEntity.class));
        if (null != menuEntities && menuEntities.size() > 0) {
            menuEntity = menuEntities.get(0);
        }
        return menuEntity;
    }

    @Override
    public List<Map<String,Object>> findByName(String username) {
        String exeSQL = "SELECT s.name   FROM wx_tab_menu  s  JOIN  wx_tab_roleMenu b ON s.id =  b.menu_id  JOIN wx_tab_role c on b.role_id= c.id  JOIN wx_tab_adminrole d on c.id =d.role_id    where admin_name=?";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(exeSQL,username);
        return list;
    }

    @Override
    public List<MenuEntity> findAllByParentId(int parentId) {
        String exeSQL = "select id,name,icon,url,parent_id as parentId from wx_tab_menu where parent_id = ?";
        Object[] args = {parentId};
        List<MenuEntity> userEntities = jdbcTemplate.query(exeSQL,args,new BeanPropertyRowMapper<>(MenuEntity.class));
        return userEntities;
    }


    /**
     * 【修改菜单信息】
     *
     * @param menuEntity
     * @return
     */
    @Override
    public int update(MenuEntity menuEntity) {
        String exeSQL = "update wx_tab_menu set name=?,icon=?,url=?,parent_id=?   WHERE id=?";
        Object args[] = {menuEntity.getName(), menuEntity.getIcon(), menuEntity.getUrl(), menuEntity.getParentId(), menuEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }


    /**
     * 【根据id删除数据】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_menu WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public int countAll() {
        String sql = "select * from wx_tab_menu";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, countCallback);
        int count = countCallback.getRowCount();
        System.out.println("目前的条数是" + count);
        return count;
    }

    /**
     * 【条件+分页】
     */
    @Override
    public List<Map<String, Object>> findListAndPage(MenuEntity menuEntity, int page, int size) {
        int starter = (page - 1) * size;
        StringBuffer sql = getQuerySql(menuEntity);
        sql.append("    ORDER BY id ASC LIMIT  " + starter + " , " + size);
        String exeSQL = sql.toString();
        log.debug(exeSQL);
        System.out.println("执行的SQL:" + exeSQL);
        List<Map<String, Object>> con = jdbcTemplate.queryForList(exeSQL);
        return con;
    }

    @Override
    public int adds(Map<String, MenuEntity> menuEntity) {
//        brandEntity.
        return 0;
    }

    private StringBuffer getQuerySql(MenuEntity menuEntity) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id,name,icon,url,parent_id as parentId FROM wx_tab_menu WHERE 1=1");
        if (!StringUtils.isEmpty(menuEntity.getId()) && menuEntity.getId() != 0) {
            sql.append("    AND id=" + menuEntity.getId());
        }
        if (!StringUtils.isEmpty(menuEntity.getName())) {
            sql.append("    AND name='" + menuEntity.getName() + "'");
        }
        if (!StringUtils.isEmpty(menuEntity.getIcon())) {
            sql.append("    AND icon='" + menuEntity.getIcon() + "'");
        }
        if (!StringUtils.isEmpty(menuEntity.getUrl())) {
            sql.append("    AND url='" + menuEntity.getUrl() + "'");
        }

        if (!StringUtils.isEmpty(menuEntity.getParentId())) {
            sql.append("    AND parentId=" + menuEntity.getParentId());
        }
        return sql;
    }

    @Override
    public List<MenuTreeNodeEntity> findNodeAll() {
        String exeSQL = "select id,name,icon,url,parent_id from wx_tab_menu";
        List<MenuTreeNodeEntity> userEntities = jdbcTemplate.query(exeSQL,new BeanPropertyRowMapper<>(MenuTreeNodeEntity.class));
        return userEntities;
    }

    @Override
    public List<Integer> findMenuByRoleId(int roleId) {
        String exeSQL = "select menu_id from wx_tab_roleMenu where role_id=?";
        Object[] args = {roleId};
        List<Integer> idList = jdbcTemplate.queryForList(exeSQL,args,Integer.class);
        return idList;
    }
}
