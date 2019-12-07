package com.cn.wanxi.service.category.impl;

import com.cn.wanxi.dao.category.ICategoryDao;
import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.category.CategoryTreeNodeEntity;
import com.cn.wanxi.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao iCategoryDao;


    @Override
    public List<CategoryEntity> findAll() {
        return iCategoryDao.findAll();
    }

    @Override
    public List<CategoryEntity> findAllByParentId(int parentId) {
        return iCategoryDao.findAllByParentId(parentId);
    }

    @Override
    public boolean add(CategoryEntity categoryEntity) {
        return iCategoryDao.insert(categoryEntity);
    }

    @Override
    public boolean update(CategoryEntity categoryEntity) {
        return iCategoryDao.update(categoryEntity);
    }

    @Override
    public boolean delete(int id) {
        return iCategoryDao.deleteById(id);
    }

    @Override
    public ArrayList<CategoryTreeNodeEntity> getCategoryTree() {
        List<CategoryTreeNodeEntity> all = iCategoryDao.findNodeAll();

        //一级菜单
        ArrayList<CategoryTreeNodeEntity> result = getSubList(all,0);
        //二级菜单
        for(int i = 0;i < result.size();++i){
            CategoryTreeNodeEntity temp = result.get(i);
            ArrayList<CategoryTreeNodeEntity> tempList = getSubList(all,temp.getId());
            //三级菜单
            for(int j = 0;j < tempList.size();++j){
                CategoryTreeNodeEntity tempInner = tempList.get(j);
                ArrayList<CategoryTreeNodeEntity> tempInnerList = getSubList(all,tempInner.getId());
                tempInner.setList(tempInnerList);
            }
            temp.setList(tempList);
        }
        return result;
    }

    private ArrayList<CategoryTreeNodeEntity> getSubList(List<CategoryTreeNodeEntity> target,int id){
        ArrayList<CategoryTreeNodeEntity> result = new ArrayList<>();
        for(CategoryTreeNodeEntity iter : target){
            if(id == iter.getParentId()){
                result.add(iter);
            }
        }
        return result;
    }
}
