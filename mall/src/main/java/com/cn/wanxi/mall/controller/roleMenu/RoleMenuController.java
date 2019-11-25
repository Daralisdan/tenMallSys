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

import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.roleMenu.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Autowired
    private IRoleMenuService iRoleMenuService;

    @PostMapping("/add")
    public Msg add(int roleid, String menuid,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int[] result = iRoleMenuService.batchCarFlowInsert(roleid, menuid);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }


    @PostMapping("/cancel")
    public Msg cancel(int roleid, String menuid,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int[] result = iRoleMenuService.batchCarFlowDelete(roleid, menuid);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }
}
