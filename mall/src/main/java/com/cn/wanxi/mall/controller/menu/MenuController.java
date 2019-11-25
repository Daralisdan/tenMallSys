package com.cn.wanxi.mall.controller.menu;

import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.PageList;
import com.cn.wanxi.service.menu.IMenuService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by zhoushiling
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService iMenuService;

    /**
     * 【添加菜品信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(MenuEntity menuEntity, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg m;
        int result = iMenuService.add(menuEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(menuEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【查询所有菜品信息】
     *
     * @return
     */

    @PostMapping("/findAll")
    public Msg findAll(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        List<Map<String, Object>> list = iMenuService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }
    /**
     * 【通过id查询菜品信息】
     *
     * @return
     */

    @PostMapping(value = "/findById")
    public Msg findById(int id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        MenuEntity byId = iMenuService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData( byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【修改菜品信息】
     *
     * @return
     */
    @PostMapping("/update")
    public Msg updateInfo(MenuEntity menuEntity,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Msg msg = null;
        int up = iMenuService.update(menuEntity);
        if (up > 0) {
            msg = Msg.success().messageData(menuEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【删除菜品信息】
     *
     * @return
     */

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

    /**
     * 【获取条件查询菜品信息】
     *
     * @return
     */
    @PostMapping("/findCondMenu")
    public Msg findByConditionPage(MenuEntity menuEntity, int page, int size) {
        Msg m;
        //实例化 分页实体类
        PageList pageList = new PageList();
        //根据页数，每页记录数查询
        List<Map<String, Object>> list = iMenuService.findListAndPage(menuEntity, page, size);
        //把查询出来的对象封装在分页实体类中
        pageList.setList(list);
        //统计所有数据的总行数
        int TotalRows = iMenuService.countAll();
        //把页数封装在分页实体类中
        pageList.setPage(page);
        //查询出来的总行数封装在分页实体类中
        pageList.setTotalRows(TotalRows);
        if (list.isEmpty()) {
            m = Msg.fail();
        } else {
            int pages = 0;
            if (TotalRows % size == 0) {
                pages = TotalRows / size;
            } else {
                pages = TotalRows / size + 1;
            }
            System.out.println("目前分页的总页数是" + pages);
            //总页数
            pageList.setPages(pages);
            m = Msg.success().messageData(pageList);
        }
        return m;
    }
}
