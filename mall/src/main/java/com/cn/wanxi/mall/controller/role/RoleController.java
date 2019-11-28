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

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.role.RoleEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
        Msg msg=null;
        if (null != roleEntity.getRoleName() && roleEntity.getRoleName().trim() != "") {
            int result = iRoleService.add(roleEntity);
            if (0 != result) {
                msg = Msg.success().messageData(roleEntity);
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        return msg;
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
    public Msg findById(@RequestBody Map<String, Integer> param) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            RoleEntity byId = iRoleService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该品牌不存在");
            }
        }
        return msg;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody RoleEntity roleEntity) {
        Msg msg = null;
        int id = roleEntity.getId();
        if (id > 0) {
            //根据id查询数据
            RoleEntity byId = iRoleService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iRoleService.update(roleEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(roleEntity);
                }
            } else {
                msg = Msg.fail().messageData("该品牌不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param,HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        if (id > 0) {
            int i = iRoleService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该用户不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }
}