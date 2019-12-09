/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: roleMenuController
 * Author:   Administrator
 * Date:     2019/11/19 17:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.roleMenu;

import com.cn.wanxi.entity.roleMenu.ById;
import com.cn.wanxi.entity.roleMenu.RoleMenuEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.roleMenu.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/19
 * @since 1.0.0
 */
//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Autowired
    private IRoleMenuService iRoleMenuService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody ById byId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int roleId=byId.getRoleId();
        String menuId=byId.getMenuId();
        int[] result = iRoleMenuService.batchCarFlowInsert(roleId, menuId);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(result);
        } else {
            m = Msg.fail();
        }
        return m;
    }


    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg cancel(@RequestBody ById byId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int roleId=byId.getRoleId();
        String menuId=byId.getMenuId();
        int[] result = iRoleMenuService.batchCarFlowDelete(roleId, menuId);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @RequestMapping(value = "/findByRoleId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String,Integer> param) {
        Msg msg = null;
        int roleId =param.get("roleId");
        List<RoleMenuEntity> byRoleId = iRoleMenuService.findEntitiesByRoleId(roleId);
        if (byRoleId != null) {
            msg = Msg.success().messageData(byRoleId);
        } else {
            msg = Msg.fail().messageData("请输入正确的id");
        }
        return msg;
    }
}
