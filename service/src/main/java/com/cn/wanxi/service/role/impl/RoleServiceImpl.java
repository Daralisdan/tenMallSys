/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleServiceImpl
 * Author:   Administrator
 * Date:     2019/11/21 9:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.role.impl;

import com.cn.wanxi.dao.role.RoleDao;
import com.cn.wanxi.entity.role.RoleEntity;
import com.cn.wanxi.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class RoleServiceImpl implements IRoleService {
        @Autowired
        private RoleDao roleDao;

        /**
         * 【添加品牌信息】
         *
         * @param role
         * @return
         */
        @Override
        public int add(RoleEntity role) {
            return roleDao.insert(role);
        }

        /**
         * 【查询所有品牌信息】
         *
         * @return
         */
        @Override
        public List<Map<String, Object>> findAll() {
            return roleDao.queryAll();
        }

        /**
         * 【根据id查询】
         *
         * @param id
         * @return
         */
        @Override
        public RoleEntity findById(int id) {
            return roleDao.findById(id);
        }

        /**
         * 【根据id修改】
         *
         * @param roleEntity
         * @return
         */
        @Override
        public int update(RoleEntity roleEntity) {
            int result = 0;
            //先根据id查询，当前数据是否存在
            int id = roleEntity.getId();
            RoleEntity byId = roleDao.findById(id);
            //如果查询当前数据存在，则修改
            if (byId != null) {
                int up = roleDao.update(roleEntity);
                //如果修改成功，返回true
                if (up > 0) {
                    result = up;
                }
            }
            return result;
        }


        /**
         * 【根据id删除】
         *
         * @param id
         * @return
         */
        @Override
        public int deleteById(int id) {
            return roleDao.deleteById(id);
        }
    }