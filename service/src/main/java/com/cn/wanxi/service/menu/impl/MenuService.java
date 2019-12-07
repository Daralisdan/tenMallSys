package com.cn.wanxi.service.menu.impl;

import com.cn.wanxi.dao.menu.IMenuDao;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.MenuTreeNodeEntity;
import com.cn.wanxi.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    @Override
    public List<MenuEntity> findAllByParentId(int parentId) {
        return iMenuDao.findAllByParentId(parentId);
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

    @Override
    public ArrayList<MenuTreeNodeEntity> getMenuTree() {
        List<MenuTreeNodeEntity> all = iMenuDao.findNodeAll();

        //一级菜单
        ArrayList<MenuTreeNodeEntity> result = getSubList(all, 0);
        //二级菜单
        for (int i = 0; i < result.size(); ++i) {
            MenuTreeNodeEntity temp = result.get(i);
            ArrayList<MenuTreeNodeEntity> tempList = getSubList(all, temp.getId());
            temp.setChildren(tempList);
        }

        return result;
    }


    private ArrayList<MenuTreeNodeEntity> getSubList(List<MenuTreeNodeEntity> target,int id){
        ArrayList<MenuTreeNodeEntity> result = new ArrayList<>();
        for(MenuTreeNodeEntity iter : target){
            if(id == iter.getParentId()){
                result.add(iter);
            }
        }
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public ArrayList<LinkedHashMap<String,Object>> getMenuByRole(int roleId) {
        List<Integer> menuByRoleId = iMenuDao.findMenuByRoleId(roleId);
        List<Map<String, Object>> list = iMenuDao.queryAll();

        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<LinkedHashMap<String, Object>>();
        //一级菜单
        for(Integer iter : menuByRoleId){
            for(Map<String,Object> innerIter : list){
                if(iter.equals(innerIter.get("id"))){
                    LinkedHashMap<String,Object> temp = new LinkedHashMap<>();
                    temp.put("id",innerIter.get("id"));
                    temp.put("name",innerIter.get("name"));
                    temp.put("url",innerIter.get("url"));
                    result.add(temp);
                    break;
                }
            }
        }

        ArrayList<LinkedHashMap<String,Object>> resultList = new ArrayList<LinkedHashMap<String, Object>>();
        //二级菜单
        for(LinkedHashMap<String,Object> iter : result){
            Integer id = (Integer)iter.get("id");
            ArrayList<LinkedHashMap<String,Object>> subList = new ArrayList<LinkedHashMap<String,Object>>();
            for(Map<String, Object> innerIter : list){
                Integer parentId = (Integer)innerIter.get("parentId");
                if(id.equals(parentId)){
                    LinkedHashMap<String,Object> sub = new LinkedHashMap<>();
                    sub.put("id",innerIter.get("id"));
                    sub.put("name",innerIter.get("name"));
                    sub.put("url",innerIter.get("url"));
                    subList.add(sub);
                }
            }
            LinkedHashMap<String,Object> withList = new LinkedHashMap<>();
            withList.put("id",iter.get("id"));
            withList.put("name",iter.get("name"));
            withList.put("url",iter.get("url"));
            withList.put("list",subList);
            resultList.add(withList);
        }

        return resultList;
    }



}
