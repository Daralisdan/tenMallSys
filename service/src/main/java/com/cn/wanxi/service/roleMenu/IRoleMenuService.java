/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IRoleMenuService
 * Author:   Administrator
 * Date:     2019/11/21 15:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.roleMenu;

import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/21
 * @since 1.0.0
 */
public interface IRoleMenuService {
    //    int batchCarFlowInsert(List<RoleMenuEntity> list);
    int[] batchCarFlowInsert(int ids, String menid);

    RoleMenuEntity findByRoleId(int roleid);

    int[] batchCarFlowDelete(int ids, String menid);
}
