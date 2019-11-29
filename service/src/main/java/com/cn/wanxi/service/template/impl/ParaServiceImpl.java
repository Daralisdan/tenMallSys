package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.ParaDao;
import com.cn.wanxi.entity.template.ParaEntity;
import com.cn.wanxi.service.template.IParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:23
 */
@Service
public class ParaServiceImpl implements IParaService {

    @Autowired
    private ParaDao paraDao;

    @Override
    public int deleteById(ParaEntity paraEntity) {
        return paraDao.delete(paraEntity);
    }

    @Override
    public int add(ParaEntity paraEntity) {
        return paraDao.add(paraEntity);
    }

    @Override
    public int update(ParaEntity paraEntity) {
        return paraDao.update(paraEntity);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return paraDao.findAll();
    }

    @Override
    public Map<String, Object> find(ParaEntity paraEntity) {
        return paraDao.find(paraEntity);
    }
}
