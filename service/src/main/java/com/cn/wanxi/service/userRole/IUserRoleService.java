/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IUserRoleService
 * Author:   Administrator
 * Date:     2019/11/27 9:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.userRole;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
public interface IUserRoleService {
    int[] batchCarFlowInsert(String username, String roleid);
    int[] batchCarFlowDelete(String username ,String roleid);
    ArrayList<String> getMenuName(String username);
}
