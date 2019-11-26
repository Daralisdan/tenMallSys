/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleController
 * Author:   Administrator
 * Date:     2019/11/19 16:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.mall.controller.role;

import com.cn.wanxi.entity.role.RoleEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.role.IRoleService;
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
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody RoleEntity roleEntity , HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int result = iRoleService.add(roleEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(roleEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping("/findAll")
    public Msg findAll(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        List<Map<String, Object>> list = iRoleService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int id = param.get("id");
        RoleEntity byId = iRoleService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData(byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody RoleEntity roleEntity,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int up = iRoleService.update(roleEntity);
        if (up > 0) {
            msg = Msg.success().messageData(roleEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int id = param.get("id");
        int i = iRoleService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}