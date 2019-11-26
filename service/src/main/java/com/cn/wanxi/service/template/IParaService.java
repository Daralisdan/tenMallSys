package com.cn.wanxi.service.template;

import com.cn.wanxi.entity.template.ParaEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:23
 */
public interface IParaService {

    int deleteById(ParaEntity paraEntity);

    int add(ParaEntity paraEntity);

    List<Map<String, Object>> findAll();

    Map<String, Object> find(ParaEntity paraEntity, Integer page, Integer size);

    int update(ParaEntity paraEntity);

}
