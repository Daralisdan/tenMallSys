/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuDao
 * Author:   Administrator
 * Date:     2019/11/21 14:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.roleMenu;

import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;

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
public interface RoleMenuDao {

    //    int batchCarFlowInsert(List<RoleMenuEntity> list);
    int[] batchCarFlowInsert(int ids, String menid);

    RoleMenuEntity findByRoleId(int roleid);

    int[] batchCarFlowDelete(int ids, String menid);
}