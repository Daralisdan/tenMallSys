package com.cn.wanxi.mall.controller.menu;

import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.service.menu.IMenuService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by yaodan
 */
public class MenuController {
    @Autowired
    private IMenuService iMenuService;

    /**
     * 【添加品牌信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(MenuEntity menuEntity,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int result = iMenuService.add(menuEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("menu", menuEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping("/list")
    public Msg findAll(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        List<Map<String, Object>> list = iMenuService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("menu", list);
        }
        return msg;
    }

    @PostMapping(value = "/findByid")
    public Msg findById(int id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        MenuEntity byId = iMenuService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("menu", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @PostMapping("/update")
    public Msg updateInfo(MenuEntity menuEntity,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int up = iMenuService.update(menuEntity);
        if (up > 0) {
            msg = Msg.success().messageData("menu", menuEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    @PostMapping("/delete")
    public Msg deleteById(int id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int i = iMenuService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

//    @RequestMapping(value = "/findCondMenu", method = RequestMethod.POST)
//    public List<MenuEntity> menufindCondMenu(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        List<MenuEntity> list = new ArrayList();
//        Integer.parseInt(request.getParameter("page"));
//        Integer.parseInt(request.getParameter("size"));
//        Integer Total=0;
//        String sql = "select * from wx_tab_menu  limit " + (Integer.parseInt(request.getParameter("page")) - 1) * Integer.parseInt(request.getParameter("size")) + "," + Integer.parseInt(request.getParameter("size")) + "";
//
//        ResultSet query = JDBC.query(sql);
//        try {
//            while (query.next()) {
//                MenuEntity menuEntity=new MenuEntity();
//                menuEntity.setId(query.getInt("id"));
//                menuEntity.setName(query.getString("name"));
//                menuEntity.setIcon(query.getString("icon"));
//                menuEntity.setParentid(query.getString("parent_id"));
//                menuEntity.setUrl(query.getString("url"));
//                list.add(menuEntity);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
