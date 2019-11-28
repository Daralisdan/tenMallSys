/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserRoleController
 * Author:   Administrator
 * Date:     2019/11/27 9:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.userRole;

import com.cn.wanxi.entity.roleMenu.ById;
import com.cn.wanxi.service.userRole.IUserRoleService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private IUserRoleService iUserRoleService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody Map<String,String> param) {
        Msg m;
        String username=param.get("username");
        String roleId=param.get("roleId");
        int[] result = iUserRoleService.batchCarFlowInsert(username,roleId);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg cancel(@RequestBody Map<String,String> param){
        Msg m;
        String username=param.get("username");
        String roleId=param.get("roleId");
        int[] result = iUserRoleService.batchCarFlowDelete(username,roleId);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }
}