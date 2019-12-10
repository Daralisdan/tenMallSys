package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:24
 */
@Service
public class SepcServiceImpl implements ISepcService {

    @Autowired
    private SepcDao sepcDao;


    @Override
    public Map<String, Object> findCondPage(SepcEntity sepcEntity) {
        List name = sepcDao.findPageBySepcName(sepcEntity);
        int sepcId = sepcDao.findIdBySepcName(sepcEntity.getName());
        List options = sepcDao.findIdBySepcOptions(sepcId);
        Map<String, Object> map = null;
        map.put("options", options);
        map.put("rows", name);
        return map;
    }


    @Override
    public boolean deleteById(int id) {
        if (sepcDao.delete(id) >= 2) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(sepcDao.findAll());
        return list;
    }


    @Override
    public int update(SepcEntity sepcEntity) {
        return sepcDao.update(sepcEntity);
    }


    /**
     * 列表中有name字段的添加
     *
     * @param options
     * @param seq
     * @param templateId
     * @return
     */
    @Override
    public boolean add(String name, String options, int seq, int templateId) {
        int sepcId = sepcDao.findIdBySepcName(name);
        int addNameOptionsResult = 0;
        int addOptionsResult = sepcDao.addSepcOptions(options, sepcId);
        if (sepcDao.isNameExist(name).size() == 0) {
            addNameOptionsResult = sepcDao.addSepcName(name, seq, templateId);
        }
        if ((addOptionsResult + addNameOptionsResult) >= 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断输入的name是否存在
     *
     * @param name
     * @return
     */
    @Override
    public boolean isNameExist(String name) {
        List list = sepcDao.isNameExist(name);
        if (list.size() == 0) {
            return false; //数据库中没有此name
        } else {
            return true;//数据库中有此name
        }
    }
}
