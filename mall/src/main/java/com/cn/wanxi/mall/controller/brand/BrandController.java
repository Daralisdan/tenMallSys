package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.PageList;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.utils.utils.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 【品牌管理模块】
 * <p>
 * 数据表： wx_tab_brand	品牌表
 *
 * @author 2019/11/16,Create by yaodan
 */
@Api(value = "xx接口")
@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private IBrandService iBrandService;

    /**
     * 【添加品牌信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(BrandEntity brandEntity) {
        Msg msg;
        int result = iBrandService.add(brandEntity);
        if (0 != result) {
            msg = Msg.success().messageData("brand", brandEntity);
        } else {
            msg = Msg.fail().messageData("info", "名字不能为空");
        }
        return msg;
    }

    /**
     * 【展示所有品牌信息】
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iBrandService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("info", "数据库中没有数据");
        } else {
            msg = Msg.success().messageData("brand", list);
        }
        return msg;
    }

    /**
     * 【根据品牌id查询信息】
     *
     * @param id
     * @return
     * @RequestParam(required = true) int id  提示必须输入id
     */
    @ApiOperation(value = "根据id查询数据")
    @PostMapping(value = "/findById")
    public Msg findById(@RequestParam(required = true) int id) {
        Msg msg;
        BrandEntity byId = iBrandService.findById(id);
        //判断是否有返回的数据
        if (!ObjectUtils.isEmpty(byId)) {
            msg = Msg.success().messageData("brand", byId);
        } else {
            msg = Msg.fail().messageData("info", "该品牌不存在");
        }
        return msg;
    }

    /**
     * 【修改品牌信息】根据id查询
     *
     * @param brandEntity
     * @return
     */
    @PostMapping("/update")
    public Msg update(BrandEntity brandEntity) {
        Msg msg = null;
        //先获取id
        int id = brandEntity.getId();
        if (id > 0) {
            //根据id查询数据
            BrandEntity byId = iBrandService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iBrandService.update(brandEntity);
                if (result > 0) {
                    msg = Msg.success().messageData("brand", brandEntity);
                }
            } else {
                msg = Msg.fail().messageData("info", "该品牌不存在");
            }
        } else {
            msg = Msg.fail().messageData("info", "请输入id");
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除数据")
    @PostMapping("/delete")
    public Msg deleteById(@RequestParam(required = true) int id) {
        Msg msg = null;
        int i = iBrandService.deleteById(id);
        if (i > 0) {
            msg = Msg.success().messageData("info", "删除成功");
        } else {
            msg = Msg.fail().messageData("info", "删除失败,该用户不存在");
        }
        return msg;
    }

    /**
     * 【条件查询】
     *
     * @return
     */
    @PostMapping(value = "/findList")
    public Msg findList(BrandEntity brandEntity) {
        Msg msg;
        List<Map<String, Object>> list = iBrandService.findList(brandEntity);
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("info", "该品牌不存在");
        } else {
            msg = Msg.success().messageData("brand", list);
        }
        return msg;
    }

    /**
     * 分页查询
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return
     */
    @PostMapping("/findAllbyPager")
    public Msg findAllbyPager(int page, int size) {
        Msg msg;
        //实例化 分页实体类
        PageList pageList = new PageList();

        //处理int类型的变量为空时
        if (page == 0) {
            page = 1;
        }
        if (size == 0) {
            page = 30;
        }
        //根据页数，每页记录数查询
        List<Map<String, Object>> list = iBrandService.findAllbyPage(page, size);
        //把查询出来的对象封装在分页实体类中
        pageList.setList(list);
        if (null == list && list.isEmpty()) {
            msg = Msg.fail().messageData("info", "品牌信息不存在");
        } else {

            //统计所有数据的总行数
            int TotalRows = iBrandService.countAll();

            //把页数封装在分页实体类中
            pageList.setPage(page);
            pageList.setTotal(list.size());
            //查询出来的总行数封装在分页实体类中
            pageList.setTotalRows(TotalRows);
            msg = getPages(size, pageList, TotalRows);
        }
        return msg;
    }

    /**
     * 【根据条件分页查询】
     *
     * @return
     */
    @PostMapping("/findByConditionPage")
    public Msg findByConditionPage(BrandEntity brandEntity, int page, int size) {
        Msg msg;
        //实例化 分页实体类
        PageList pageList = new PageList();
        //根据页数，每页记录数查询
        List<Map<String, Object>> list = iBrandService.findListAndPage(brandEntity, page, size);
        //把查询出来的对象封装在分页实体类中
        pageList.setList(list);
        //统计所有数据的总行数
        int TotalRows = iBrandService.countAll();
        //把页数封装在分页实体类中
        pageList.setPage(page);
        pageList.setTotal(list.size());
        //查询出来的总行数封装在分页实体类中
        pageList.setTotalRows(TotalRows);
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("info", "品牌信息不存在");
        } else {
            msg = getPages(size, pageList, TotalRows);
        }
        return msg;
    }

    /**
     * 提取公共方法
     * @param size
     * @param pageList
     * @param totalRows 总记录数
     * @return
     */
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
        msg = Msg.success().messageData("brand", pageList);
        return msg;
    }
}
