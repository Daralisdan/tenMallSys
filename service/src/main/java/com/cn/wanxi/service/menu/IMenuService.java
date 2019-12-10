package com.cn.wanxi.service.menu;

import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.MenuTreeNodeEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface IMenuService {
    int deleteById(int id);

    int add(MenuEntity menuEntity);

    List<Map<String, Object>> findAll();

    MenuEntity findById(int id);
    List<Map<String,Object>> findByName(String username);
    List<MenuEntity> findAllByParentId(int parentId);

    int update(MenuEntity menuEntity);
    List<Map<String, Object>> findListAndPage(MenuEntity menuEntity, int page, int size);
    int countAll();
    ArrayList<MenuTreeNodeEntity> getMenuTree();
    ArrayList<LinkedHashMap<String,Object>> getMenuByRole(int roleId);
}
