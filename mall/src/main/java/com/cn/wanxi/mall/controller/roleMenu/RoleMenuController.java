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
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.roleMenu.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
        int roleid=byId.getRoleid();
        String menuid=byId.getMenuid();
        int[] result = iRoleMenuService.batchCarFlowInsert(roleid, menuid);
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
        int roleid=byId.getRoleid();
        String menuid=byId.getMenuid();
        int[] result = iRoleMenuService.batchCarFlowDelete(roleid, menuid);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }
}
