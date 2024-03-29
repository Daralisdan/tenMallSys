package com.cn.wanxi.dao.template;

import com.cn.wanxi.entity.template.TemplateEntity;

import java.util.List;
import java.util.Map;


/**
 * 2019/11/18,Create by ssj
 */

public interface TemplateDao {


    int add(TemplateEntity templateEntity);


    Map<String, Object> find(TemplateEntity templateEntity);


    List<Map<String, Object>> findAll();


    int update(TemplateEntity templateEntity);


    int delete(TemplateEntity templateEntity);

    Map<String,Object> findSpecsById(TemplateEntity templateEntity);

    int findIdByName(String name);
}
