package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:24
 */
@Service
public class SepcServiceImpl implements ISepcService {

    @Autowired
    private SepcDao sepcDao;

    @Override
    public int deleteById(int id) {
        return sepcDao.delete(id);
    }


    @Override
    public List<Map<String, Object>> findAll() {
        return sepcDao.findAll();
    }

    @Override
    public int add(SepcEntity sepcEntity) {
        return sepcDao.add(sepcEntity);
    }

    @Override
    public int update(SepcEntity sepcEntity) {
        return sepcDao.update(sepcEntity);
    }

    @Override
    public Map<String, Object> find(SepcEntity sepcEntity, Integer page, Integer size) {
        return sepcDao.find(sepcEntity, page, size);
    }
}
