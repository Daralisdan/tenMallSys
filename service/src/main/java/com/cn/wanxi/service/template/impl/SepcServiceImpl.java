package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:24
 */
@Service
public class SepcServiceImpl implements ISepcService {

    @Autowired
    private SepcDao sepcDao;


    @Override
    public int deleteById(SepcEntity sepcEntity) {
        return sepcDao.delete(sepcEntity);
    }


    @Override
    public List<Map<String, Object>> findAll() {
        return sepcDao.findAll();
    }


    @Override
    public int update(SepcEntity sepcEntity) {
        return sepcDao.update(sepcEntity);
    }

    /**
     * 新增规格
     *
     * @param sepcEntity
     * @return
     */
    @Override
    public int add(SepcEntity sepcEntity) {
        int tempAddSepcName = sepcDao.addSepcName(sepcEntity);
        int sepcId = sepcDao.getSepcId();
        int tempAddSepcOptions = sepcDao.addSepcOptions(sepcEntity.getOptions(), sepcId);
        return tempAddSepcOptions + tempAddSepcName;
    }

    @Override
    public Map<String, Object>  findCondPage(SepcEntity sepcEntity) {
        List name = sepcDao.findPageBySepcName(sepcEntity);
        int sepcId = sepcDao.findSepcId(sepcEntity.getName());
        List options= sepcDao.findIdBySepcOptions(sepcId);
        Map<String, Object> map = null;
        map.put("options", options);
        map.put("rows", name);
        return map;


    }
}
