package com.cn.wanxi.dao.template;

import com.cn.wanxi.entity.template.ParaEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
public interface ParaDao {

    int add(ParaEntity paraEntity);


    Map<String, Object> find(ParaEntity paraEntity);


    List<Map<String, Object>> findAll();


    int update(ParaEntity paraEntity);


    int delete(ParaEntity paraEntity);
}
