package com.cn.wanxi.dao.menu;

import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.MenuTreeNodeEntity;

import java.util.List;
import java.util.Map;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by zhoushiling
 */
public interface IMenuDao {
    /**
     * 【添加菜单信息】
     *
     * @param menu
     * @return
     */
    int insert(MenuEntity menu);

    /**
     * 【查询所有菜单信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询菜单信息】
     *
     * @param id
     * @return
     */
    MenuEntity findById(int id);

    /**
     * 【修改菜单信息】
     *
     * @param menuEntity
     * @return
     */
    int update(MenuEntity menuEntity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
    int countAll();
    int adds(Map<String, MenuEntity> menuEntity);
    List<Map<String,Object>> findByName(String username);
    List<MenuEntity> findAllByParentId(int parentId);

    List<Map<String, Object>> findListAndPage(MenuEntity menuEntity, int page, int size);
    List<MenuTreeNodeEntity> findNodeAll();
    List<Integer> findMenuByRoleId(int roleId);
}
