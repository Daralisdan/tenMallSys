package com.cn.wanxi.dao.template;

import com.cn.wanxi.entity.template.SepcEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
public interface SepcDao {

    int add(SepcEntity sepcEntity);


    Map<String, Object> find(SepcEntity sepcEntity, Integer page, Integer size);


    List<Map<String, Object>> findAll();


    int update(SepcEntity sepcEntity);


    int delete(int id);
}
