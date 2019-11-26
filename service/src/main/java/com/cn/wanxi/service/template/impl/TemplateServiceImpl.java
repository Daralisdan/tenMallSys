package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.TemplateDao;
import com.cn.wanxi.entity.template.TemplateEntity;
import com.cn.wanxi.service.template.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by ssj
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private TemplateDao templateDao;

    @Override
    public int deleteById(TemplateEntity templateEntity) {
        return templateDao.delete(templateEntity);
    }

//    @Override
////    public Map<String, Object> find(TemplateEntity templateEntity, Integer page, Integer size) {
////        return templateDao.find(templateEntity, page, size);
////    }


    @Override
    public Map<String, Object> find(TemplateEntity templateEntity) {
        return templateDao.find(templateEntity);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return templateDao.findAll();
    }

    @Override
    public int add(TemplateEntity templateEntity) {
        return templateDao.add(templateEntity);
    }

    @Override
    public int update(TemplateEntity templateEntity) {
        return templateDao.update(templateEntity);
    }
}
