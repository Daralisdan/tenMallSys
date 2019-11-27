package com.cn.wanxi.service.template.impl;

import com.cn.wanxi.dao.template.SepcDao;
import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteById(SepcEntity sepcEntity) {
        return sepcDao.delete(sepcEntity);
    }


    @Override
    public List<Map<String, Object>> findAll() {
        return sepcDao.findAll();
    }

    @Override
    public boolean add(SepcEntity sepcEntity) {
        String sql = "select template_id from wx_tab_template where id = " + sepcEntity.getTemplateId();
        List list = jdbcTemplate.queryForList(sql);
        if (list.size() != 0) {
            sepcDao.add(sepcEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int update(SepcEntity sepcEntity) {
        return sepcDao.update(sepcEntity);
    }

    @Override
    public Map<String, Object> find(SepcEntity sepcEntity) {
        return sepcDao.find(sepcEntity);
    }
}
