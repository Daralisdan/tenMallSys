/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuServiceImpl
 * Author:   Administrator
 * Date:     2019/11/21 15:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.roleMenu.Impl;

import com.cn.wanxi.dao.roleMenu.RoleMenuDao;
import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;
import com.cn.wanxi.service.roleMenu.IRoleMenuService;
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
public  class RoleMenuServiceImpl implements IRoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public int[] batchCarFlowInsert(int  ids , String menid){

        return roleMenuDao.batchCarFlowInsert(ids,menid);

    }

    public RoleMenuEntity findByRoleId(int roleid){
        return roleMenuDao.findByRoleId(roleid);
    }

    public int[] batchCarFlowDelete(int  ids ,String menid){
        return roleMenuDao.batchCarFlowDelete(ids, menid);
    }


}
