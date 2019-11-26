package com.cn.wanxi.service.template;

import com.cn.wanxi.entity.template.SepcEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:23
 */
public interface ISepcService {

    int deleteById(SepcEntity sepcEntity);

    int add(SepcEntity sepcEntity);

    List<Map<String, Object>> findAll();

    Map<String, Object> find(SepcEntity sepcEntity, Integer page, Integer size);

    int update(SepcEntity sepcEntity);

}
