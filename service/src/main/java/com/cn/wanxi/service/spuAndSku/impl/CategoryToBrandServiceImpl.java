package com.cn.wanxi.service.spuAndSku.impl;

import com.cn.wanxi.dao.product.CategoryToBrandDao;
import com.cn.wanxi.entity.product.CategoryToBrand;
import com.cn.wanxi.service.spuAndSku.ICategoryToBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LessonWong
 * @date 2019/11/19 12:38
 */
@Service
public class CategoryToBrandServiceImpl implements ICategoryToBrandService {

    @Autowired
    private CategoryToBrandDao categoryToBrandDao;

    @Override
    public int deleteById(int id) {
        return categoryToBrandDao.deleteById(id);
    }

    @Override
    public int add(CategoryToBrand categoryToBrandEntity) {
        return categoryToBrandDao.insert(categoryToBrandEntity);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return categoryToBrandDao.queryAll();
    }

    @Override
    public CategoryToBrand findById(int id) {
        return categoryToBrandDao.findById(id);
    }

    @Override
    public int update(CategoryToBrand categoryToBrandEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = categoryToBrandEntity.getBrand_id();
        CategoryToBrand byId = categoryToBrandDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = categoryToBrandDao.update(categoryToBrandEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
}
