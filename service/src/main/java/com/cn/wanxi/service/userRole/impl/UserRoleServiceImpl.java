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
package com.cn.wanxi.service.userRole.impl;

import com.cn.wanxi.dao.userRole.UserRoleDao;
import com.cn.wanxi.service.userRole.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public int[] batchCarFlowInsert(String username , String roleid){

        return userRoleDao.batchCarFlowInsert(username,roleid);

    }

    @Override
    public int[] batchCarFlowDelete(String username ,String roleid){
        return userRoleDao.batchCarFlowDelete(username,roleid);
    }

}