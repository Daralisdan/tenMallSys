/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IAdminRoleDao
 * Author:   Administrator
 * Date:     2019/11/27 9:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.dao.AdminRole;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
public interface IAdminRoleDao {
    int[] batchCarFlowInsert(String adminName, String roleId);
    int[] batchCarFlowDelete(String adminName ,String roleId);
    Integer selectRoleByUsername(String adminName);
}
