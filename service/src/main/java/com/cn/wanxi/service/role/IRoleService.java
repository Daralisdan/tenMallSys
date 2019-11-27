/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IRoleService
 * Author:   Administrator
 * Date:     2019/11/21 9:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.service.role;

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
public interface IRoleService {
    int deleteById(int id);

    int add(RoleEntity roleEntity);

    List<Map<String, Object>> findAll();

    RoleEntity findById(int id);

    int update(RoleEntity roleEntity);
}
