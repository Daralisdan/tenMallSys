package com.cn.wanxi.dao.template;

import com.cn.wanxi.entity.template.SepcEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
public interface SepcDao {

    int addSepcName(SepcEntity sepcEntity);

    int addSepcOptions(String Options, int sepcId);

    Integer getSepcId();

    List findPageBySepcName(SepcEntity sepcEntity);

    List findIdBySepcOptions(int id);


    List<Map<String, Object>> findAll();


    int update(SepcEntity sepcEntity);


    int delete(SepcEntity sepcEntity);

    int findSepcId(String name);
}
