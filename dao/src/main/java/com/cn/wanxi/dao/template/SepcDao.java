package com.cn.wanxi.dao.template;

import com.cn.wanxi.entity.template.SepcEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: SSJ
 * @Date: 11月19日 16:15
 */
public interface SepcDao {

    int addSepcName(String name,int templateId);

//    int addSepcOptions(String options, int sepcId);

    int findIdBySepcName(String name);

    List findPageBySepcName(String name);

    List findIdBySepcOptions(int id);

    Map<String, Object> findAll();

    int updateSepcName(int id, String name);

//    int updateSepcOptions(String options, int sepcId);

    int delete(int id);

    List isNameExist(String name);
}
