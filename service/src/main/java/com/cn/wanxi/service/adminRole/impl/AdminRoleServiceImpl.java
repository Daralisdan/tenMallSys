/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserRoleServiceImpl
 * Author:   Administrator
 * Date:     2019/11/27 9:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.adminRole.impl;

import com.cn.wanxi.dao.AdminRole.IAdminRoleDao;
import com.cn.wanxi.dao.menu.IMenuDao;
import com.cn.wanxi.dao.roleMenu.RoleMenuDao;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;
import com.cn.wanxi.service.adminRole.IAdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@Service
public class AdminRoleServiceImpl implements IAdminRoleService {
    @Autowired
    private IAdminRoleDao iAdminRoleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private IMenuDao iMenuDao;

    @Override
    public int[] batchCarFlowInsert(String adminName , String roleId){
        return iAdminRoleDao.batchCarFlowInsert(adminName,roleId);
    }

    @Override
    public int[] batchCarFlowDelete(String adminName ,String roleId){
        return iAdminRoleDao.batchCarFlowDelete(adminName,roleId);
    }

    @Override
    public ArrayList<String> getMenuName(String adminName) {
        Integer roleId = iAdminRoleDao.selectRoleByUsername(adminName);
        List<RoleMenuEntity> byRoleId = roleMenuDao.findEntitiesByRoleId(roleId);

        ArrayList<String> menuNameList = new ArrayList<>();
        for(RoleMenuEntity iter : byRoleId){
            Integer menuId = iter.getMenuId();
            MenuEntity menuTemp = iMenuDao.findById(menuId);
            if(null !=menuTemp){
                menuNameList.add(menuTemp.getName());
            }

        }
        return menuNameList;
    }

}