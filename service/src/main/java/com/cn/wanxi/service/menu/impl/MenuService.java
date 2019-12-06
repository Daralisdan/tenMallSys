package com.cn.wanxi.service.menu.impl;

import com.cn.wanxi.dao.menu.IMenuDao;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by yaodan
 */
@Service
public class MenuService implements IMenuService {

    @Autowired
    private IMenuDao iMenuDao;

    /**
     * 【添加品牌信息】
     *
     * @param menu
     * @return
     */
    @Override
    public int add(MenuEntity menu) {
        return iMenuDao.insert(menu);
    }

    /**
     * 【查询所有品牌信息】
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return iMenuDao.queryAll();
    }

    /**
     * 【根据id查询】
     *
     * @param id
     * @return
     */
    @Override
    public MenuEntity findById(int id) {
        return iMenuDao.findById(id);
    }

    @Override
    public  List<Map<String,Object>> findByName(String username){
        return iMenuDao.findByName(username);
    }

    /**
     * 【根据id修改】
     *
     * @param menuEntity
     * @return
     */
    @Override
    public int update(MenuEntity menuEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = menuEntity.getId();
        MenuEntity byId = iMenuDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iMenuDao.update(menuEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }


    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return iMenuDao.deleteById(id);
    }

    public List<Map<String, Object>> findListAndPage(MenuEntity menuEntity, int page, int size) {
        return iMenuDao.findListAndPage(menuEntity, page, size);
    }

    @Override
    public int countAll() {
        return iMenuDao.countAll();
    }
}
