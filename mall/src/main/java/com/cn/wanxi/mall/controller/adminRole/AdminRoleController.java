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
package com.cn.wanxi.mall.controller.adminRole;

import com.cn.wanxi.service.adminRole.IAdminRoleService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/adminRole")
public class AdminRoleController {
    @Autowired
    private IAdminRoleService iAdminRoleService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody Map<String,String> param) {
        Msg m;
        String username=param.get("adminName");
        String roleId=param.get("roleId");
        int[] result = iAdminRoleService.batchCarFlowInsert(username,roleId);
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
        int[] result = iAdminRoleService.batchCarFlowDelete(username,roleId);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping(value = "/userToMenuName", produces = "application/json;charset=UTF-8")
    public Msg userToMenuName(@RequestBody Map<String,String> param) {
        Msg m;
        String username = param.get("username");
        int a = 10;
        if(isEmpty(username) || "".equals(username)){
            m = new Msg(1,"查询失败");
            return m;
        }
        ArrayList<String> menuNames = iAdminRoleService.getMenuName(username);
        m = new Msg(0,"查询成功",menuNames);
        return m;
    }
}