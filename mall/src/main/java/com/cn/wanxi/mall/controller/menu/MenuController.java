package com.cn.wanxi.mall.controller.menu;

import com.cn.wanxi.dao.menu.IMenuDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.ByPage;
import com.cn.wanxi.entity.menu.MenuEntity;
import com.cn.wanxi.entity.menu.MenuTreeNodeEntity;
import com.cn.wanxi.service.menu.IMenuService;
import com.cn.wanxi.utils.Message;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 【菜单管理】 菜单为三级菜单
 * 数据表： wx_tab_menu （菜单表）
 *
 * 2019/11/18,Create by zhoushiling
 */
@Component
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
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody MenuEntity menuEntity) {
        Msg msg = null;
        if (null != menuEntity.getName() && menuEntity.getName().trim() != "") {
            int result = iMenuService.add(menuEntity);
            if (0 != result) {
                msg = Msg.success().messageData(menuEntity);
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        return msg;
    }

    /**
     * 【查询所有菜品信息】
     *
     * @return
     */

    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg = null;
        List<Map<String, Object>> list = iMenuService.findAll();        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("数据库没有数据");
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


    @RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            MenuEntity byId = iMenuService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该菜单不存在");
            }
        }
        return msg;
    }

    /**
     * 【通过name查询菜品信息】
     *
     * @return
     */
    @RequestMapping(value = "/findAuthMenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findByName(@RequestBody Map<String,String> param) {
        Msg msg = null;
        String adminname = param.get("adminname");
        List<Map<String,Object>>  byName = iMenuService.findByName(adminname);
        if (byName != null) {
            msg = Msg.success().messageData(byName);
        } else {
            msg = Msg.fail().messageData("请输入正确的名字");
        }
        return msg;
    }

    /**
     * 【固定条件查询所有，固定parent_id】
     *
     * @return
     */
    @PostMapping(value = "/listSub",produces = "application/json;charset=UTF-8")
    public Message listSub(@RequestBody Map<String,String> args){
        Integer parentId = Integer.parseInt(args.get("parentId"));
        Message m = new Message();
        List<MenuEntity> result = iMenuService.findAllByParentId(parentId);
        if(!isEmpty(result)){
            m.setCode(0);
            m.setMessage("根据parentId查询菜单");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败或数据库中数据条数为0");
        }
        return m;
    }

    /**
     * 【修改菜品信息】
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg update(@RequestBody MenuEntity menuEntity) {
        Msg msg = null;
        int id = menuEntity.getId();
        if (id > 0) {
            //根据id查询数据
            MenuEntity byId = iMenuService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iMenuService.update(menuEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(menuEntity);
                }
            } else {
                msg = Msg.fail().messageData("该品牌不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    /**
     * 【删除菜品信息】
     *
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param) {
        Msg msg = null;
        int id = param.get("id");
        if (id > 0) {
            int i = iMenuService.deleteById(id);
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

    /**
     * 【获取条件查询菜品信息】
     *
     * @return
     */
    @RequestMapping(value = "/findCondPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findByConditionPage(@RequestBody Map<String,Object> param) {
        Msg msg;
        int i=0;
        int j=0;
        Object name=param.get("name");
        Object page = param.get("page");
        Object size = param.get("size");
       if(page==null&&size==null){
           msg = Msg.fail().messageData("page,size不能为空");
           return msg;
       }
        i=Integer.parseInt(page.toString());
        j=Integer.parseInt(size.toString());
        MenuEntity menuEntity = new MenuEntity();
        if (name != null) {
            menuEntity.setName(name.toString());
        }

        //实例化 分页实体类
        PageList pageList = new PageList();
        //根据页数，每页记录数查询
        List<Map<String, Object>> list = iMenuService.findListAndPage(menuEntity, i, j);
        //把查询出来的对象封装在分页实体类中
        pageList.setRows(list);
        //统计所有数据的总行数
        int TotalRows = iMenuService.countAll();
        //把页数封装在分页实体类中
        pageList.setPage(i);
        pageList.setTotal(list.size());
        //查询出来的总行数封装在分页实体类中
        pageList.setTotalRows(TotalRows);
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("菜单信息不存在");
        } else {
            msg = getPages(j, pageList, TotalRows);
        }
        return msg;
    }

    private Msg getPages(int size, PageList pageList, int totalRows) {
        Msg msg;
        int pages = 0;
        if (totalRows % size == 0) {
            pages = totalRows / size;
        } else {
            pages = totalRows / size + 1;
        }
        System.out.println("目前分页的总页数是" + pages);
        //总页数
        pageList.setPages(pages);
        msg = Msg.success().messageData(pageList);
        return msg;
    }

    /**
     * 【菜单树】
     *
     * @return
     */
    @PostMapping(value = "/menuListT",produces = "application/json;charset=UTF-8")
    public Message menuListT(){
        Message m = new Message();
        ArrayList<MenuTreeNodeEntity> result = iMenuService.getMenuTree();
        if (0 < result.size()) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【】
     *
     * @return
     */
    @PostMapping(value = "/findMenuByRoleId",produces = "application/json;charset=UTF-8")
    public Message findmenuByRoleId(@RequestBody Map<String,Integer> args){
        int roleId =args.get("roleId");
        Message m = new Message();
        ArrayList<LinkedHashMap<String,Object>> result = iMenuService.getMenuByRole(roleId);
        if (0 < result.size()) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }
}
