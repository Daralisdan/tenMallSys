package com.cn.wanxi.dao.template;

import java.util.List;
import java.util.Map;
import com.cn.wanxi.entity.template.SepcEntity;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
public interface SepcDao {

    int add(SepcEntity sepcEntity);


    Map<String, Object> find(SepcEntity sepcEntity);


    List<Map<String, Object>> findAll();


    int update(SepcEntity sepcEntity);


    int delete(SepcEntity sepcEntity);
}
