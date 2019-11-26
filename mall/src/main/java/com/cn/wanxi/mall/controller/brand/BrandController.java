package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.PageList;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;


/**
 * 【品牌管理模块】
 * <p>
 * 数据表： wx_tab_brand	品牌表
 *
 * @author 2019/11/16,Create by yaodan
 */
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
        Msg m;
        int result = iBrandService.add(brandEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(brandEntity);
        } else {
            m = Msg.fail();
        }
        return m;
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
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    /**
     * 【根据品牌id查询信息】
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/findById")
    public Msg findById(int id) {
        Msg msg = null;
        BrandEntity byId = iBrandService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData(byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【修改品牌信息】
     *
     * @param brandEntity
     * @return
     */
    @PostMapping("/update")
    public Msg updateInfo(BrandEntity brandEntity) {
        Msg msg = null;

        int up = iBrandService.update(brandEntity);
        if (up > 0) {
            msg = Msg.success().messageData(brandEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Msg deleteById(int id) {
        Msg msg = null;
        int i = iBrandService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
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
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
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

        //统计所有数据的总行数
        int TotalRows = iBrandService.countAll();

        //把页数封装在分页实体类中
        pageList.setPage(page);
        //查询出来的总行数封装在分页实体类中
        pageList.setTotalRows(TotalRows);

        int pages = 0;
        if (TotalRows % size == 0) {
            pages = TotalRows / size;
        } else {
            pages = TotalRows / size + 1;
        }
        System.out.println("目前分页的总页数是" + pages);
        //总页数
        pageList.setPages(pages);

        return Msg.success().messageData(pageList);
    }

    /**
     * 【根据条件分页查询】
     *
     * @return
     */
    @PostMapping("/findByConditionPage" )
    public Msg findByConditionPage(BrandEntity brandEntity, int page, int size) {
        Msg m;
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
