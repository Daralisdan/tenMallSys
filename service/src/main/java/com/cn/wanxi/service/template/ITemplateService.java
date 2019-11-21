package com.cn.wanxi.service.template;

import com.cn.wanxi.entity.template.TemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/18,Create by ssj
 */
public interface ITemplateService {

    int deleteById(int id);

    int add(TemplateEntity templateEntity);

    List<Map<String, Object>> findAll();

    Map<String, Object> find(TemplateEntity templateEntity, Integer page, Integer size);

    int update(TemplateEntity templateEntity);

}
