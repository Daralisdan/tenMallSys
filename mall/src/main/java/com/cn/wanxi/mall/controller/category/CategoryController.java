package com.cn.wanxi.mall.controller.category;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.PageSelect;
import com.cn.wanxi.utils.jdbcTemplateSentence.ToEntity;
import com.cn.wanxi.utils.message.Message;
import com.cn.wanxi.service.category.ICategoryService;
import com.cn.wanxi.utils.message.MessageLimit;
import com.cn.wanxi.utils.message.MessageProxy;
import com.cn.wanxi.utils.message.enums.OperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
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
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody CategoryEntity categoryEntity) {
        Message msg;
        int result = iCategoryService.add(categoryEntity);
        if (0 != result) {
            msg = MessageProxy.success(OperationTypeEnum.ADD);
        } else {
            msg = MessageProxy.fail(OperationTypeEnum.ADD);
        }
        return msg;
    }

    /**
     * 【依据条件删除】
     *
     * @param categoryEntity
     * @return
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public Message delete(@RequestBody CategoryEntity categoryEntity){
        Message msg;
        int result = iCategoryService.delete(categoryEntity);
        if (0 != result) {
            msg = MessageProxy.success(OperationTypeEnum.DELETE);
        } else {
            msg = MessageProxy.fail(OperationTypeEnum.DELETE);
        }
        return msg;
    }

    /**
     * 【依据条件更新】
     *
     * @param categoryEntity
     * @return
     */
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(@RequestBody CategoryEntity categoryEntity){
        Message msg;
        int result = iCategoryService.update(categoryEntity);
        if (0 != result) {
            msg = MessageProxy.success(OperationTypeEnum.UPDATE);
        } else {
            msg = MessageProxy.fail(OperationTypeEnum.UPDATE);
        }
        return msg;
    }

    /**
     * 【依据条件查询一条】
     *
     * @param categoryEntity
     * @return
     */
    @PostMapping(value = "/findOne",produces = "application/json;charset=UTF-8")
    public Message findOne(@RequestBody CategoryEntity categoryEntity){
        Message msg;
        List<Map<String, Object>> result = iCategoryService.findOne(categoryEntity);
        if(!isEmpty(result)){
            msg = MessageProxy.success(OperationTypeEnum.FIND, result);
        } else {
            msg = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return msg;
    }

    /**
     * 【依据条件查询分页】
     *
     * @param pageSelect
     * @return
     */
    @PostMapping(value = "/findPage",produces = "application/json;charset=UTF-8")
    public MessageLimit findPage(@RequestBody PageSelect pageSelect){
        MessageLimit msgLimit = new MessageLimit();
        CategoryEntity categoryEntity = (CategoryEntity)ToEntity.transMapToEntity(pageSelect.getEntityMap(),CategoryEntity.class);
        int page = pageSelect.getPage();
        int size = pageSelect.getSize();
        List<Map<String, Object>> result = iCategoryService.findLimit(categoryEntity,page,size);
        //计数
        int count = iCategoryService.count(categoryEntity,page,size);
        LinkedHashMap<String,Object> pagedResult = new LinkedHashMap<>();
        pagedResult.put("rows",result);
        pagedResult.put("total",count);

        if(!isEmpty(result)){
            msgLimit.setCode(0);
            msgLimit.setMessage("查询成功");
            msgLimit.setData(pagedResult);
        } else {
            msgLimit.setCode(1);
            msgLimit.setMessage("查询失败");
        }
        return msgLimit;
    }

    /**
     * 【条件查询所有】
     *
     * @return
     */
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findAll(CategoryEntity categoryEntity){
        Message msg;
        List<Map<String, Object>> result = iCategoryService.findAll(categoryEntity);
        if(!isEmpty(result)){
            msg = MessageProxy.success(OperationTypeEnum.FIND, result);
        } else {
            msg = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return msg;
    }
}
