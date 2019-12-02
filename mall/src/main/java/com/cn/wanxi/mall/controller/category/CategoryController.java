package com.cn.wanxi.mall.controller.category;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.category.CategoryTreeNodeEntity;
import com.cn.wanxi.utils.Message;
import com.cn.wanxi.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
     * 【查询所有】
     *
     * @return
     */
    @PostMapping(value = "/list",produces = "application/json;charset=UTF-8")
    public Message list(){
        Message m = new Message();

        List<CategoryEntity> result = iCategoryService.findAll();
        if(!isEmpty(result)){
            m.setCode(0);
            m.setMessage("查询所有商品分类");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败或数据库中数据条数为0");
        }
        return m;
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
        List<CategoryEntity> result = iCategoryService.findAllByParentId(parentId);
        if(!isEmpty(result)){
            m.setCode(0);
            m.setMessage("根据parentId查询商品分类");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败或数据库中数据条数为0");
        }
        return m;
    }

    /**
     * 【添加商品分类信息】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody CategoryEntity categoryEntity) {
        Message m = new Message();
        boolean isSuccess = iCategoryService.add(categoryEntity);
        if (isSuccess) {
            m.setCode(0);
            m.setMessage("添加成功");
        } else {
            m.setCode(1);
            m.setMessage("添加失败");
        }
        return m;
    }

    /**
     * 【依据条件更新】
     *
     * @param categoryEntity
     * @return
     */
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(@RequestBody CategoryEntity categoryEntity){
        Message m = new Message();
        boolean isSuccess = iCategoryService.update(categoryEntity);
        if (isSuccess) {
            m.setCode(0);
            m.setMessage("更新成功");
        } else {
            m.setCode(1);
            m.setMessage("更新失败");
        }
        return m;
    }

    /**
     * 【依据条件删除】
     *
     * @param args
     * @return
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public Message delete(@RequestBody Map<String,String> args){
        Integer id = Integer.parseInt(args.get("id"));
        Message m = new Message();
        boolean isSuccess = iCategoryService.delete(id);
        if (isSuccess) {
            m.setCode(0);
            m.setMessage("删除成功");
        } else {
            m.setCode(1);
            m.setMessage("删除失败");
        }
        return m;
    }

    /**
     * 【菜单树】
     *
     * @return
     */
    @PostMapping(value = "/categoryListT",produces = "application/json;charset=UTF-8")
    public Message categoryListT(){
        Message m = new Message();
        ArrayList<CategoryTreeNodeEntity> result = iCategoryService.getCategoryTree();
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
