package com.cn.wanxi.service.template;

import com.cn.wanxi.entity.template.SepcEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:23
 */
public interface ISepcService {

    boolean deleteById(int id);

    boolean add(String name, int templateId);

    List<Map<String, Object>> findAll();

    Map<String, Object> findCondPage(String name);

    boolean update(int id, String name);

    boolean isNameExist(String name);

}
