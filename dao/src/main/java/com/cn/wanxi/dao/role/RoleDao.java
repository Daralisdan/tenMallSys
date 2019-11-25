/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleDao
 * Author:   Administrator
 * Date:     2019/11/21 9:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.role;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.role.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/21
 * @since 1.0.0
 */
public interface RoleDao {
    /**
     * 【添加角色信息】
     *
     * @param role
     * @return
     */
    int insert(RoleEntity role);

    /**
     * 【查询所有角色信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询角色信息】
     *
     * @param id
     * @return
     */
    RoleEntity findById(int id);

    /**
     * 【修改角色信息】
     *
     * @param roleEntity
     * @return
     */
    int update(RoleEntity roleEntity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);

}