package com.cn.wanxi.mall.controller.category;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author LessonWong
 * @date 2019/11/19 13:00
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 【添加商品分类信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(CategoryEntity categoryEntity) {
        Msg m;
        int result = iCategoryService.add(categoryEntity);
        if (!isEmpty(result)) {
            m = Msg.success();
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【展示所有商品分类信息】
     *
     * @return
     */
    @PostMapping("/list")
    public Msg findAll() {
        Msg msg = null;
        List<Map<String, Object>> list = iCategoryService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (!list.isEmpty()) {
            msg = Msg.success().messageData("category",list);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【查询指定父类id所有商品分类信息】
     *
     * @return
     */
    @PostMapping("/listSub")
    public Msg findAll(int parent_id) {
        Msg msg = null;
        List<Map<String, Object>> list = iCategoryService.findByParentId(parent_id);
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("category",list);
        }
        return msg;
    }

    /**
     * 【根据商品分类id查询信息】
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/findById")
    public Msg findById(int id) {
        Msg msg;
        CategoryEntity byId = iCategoryService.findById(id);
        if (!isEmpty(byId)) {
            msg = Msg.success().messageData("category",byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【修改商品分类信息】
     *
     * @param categoryEntity
     * @return
     */
    @PostMapping("/update")
    public Msg updateInfo(CategoryEntity categoryEntity) {
        Msg msg = null;
        int up = iCategoryService.update(categoryEntity);
        if (up > 0) {
            msg = Msg.success();
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
        int i = iCategoryService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}
