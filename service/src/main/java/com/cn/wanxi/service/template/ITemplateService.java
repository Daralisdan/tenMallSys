package com.cn.wanxi.service.template;

import com.cn.wanxi.entity.template.TemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by ssj
 */
public interface ITemplateService {

    int deleteById(TemplateEntity templateEntity);

    int add(TemplateEntity templateEntity);

    List<Map<String, Object>> findAll();

    Map<String, Object> find(TemplateEntity templateEntity);

    int update(TemplateEntity templateEntity);

    Map<String,Object> findSpecsById(TemplateEntity templateEntity);

    int findIdByName(String name);
}
