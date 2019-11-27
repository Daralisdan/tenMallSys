package com.cn.wanxi.mall.controller.advertisin;

import com.cn.wanxi.dao.universal.IUniversalDao;
import com.cn.wanxi.dao.universal.impl.UniversalDaoImpl;
import com.cn.wanxi.entity.PageSelect;
import com.cn.wanxi.entity.advertisin.AdvertisinEntity;
import com.cn.wanxi.utils.jdbcTemplateSentence.ToEntity;
import com.cn.wanxi.utils.message.Message;
import com.cn.wanxi.utils.message.MessageLimit;
import com.cn.wanxi.utils.message.MessageProxy;
import com.cn.wanxi.utils.message.enums.OperationTypeEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author LeesonWong
 * @date 2019/11/26 19:49
 */
@RestController
@RequestMapping("/advertisin")
public class AdvertisinController {
    private IUniversalDao daoTemp = new UniversalDaoImpl();

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findByAll(){
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(new AdvertisinEntity());
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findTypeAll",produces = "application/json;charset=UTF-8")
    public Message findTypeAll(@RequestBody AdvertisinEntity entity){
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(entity);
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(@RequestBody AdvertisinEntity entity){
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(entity);
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/find",produces = "application/json;charset=UTF-8")
    public Message find(@RequestBody AdvertisinEntity entity){
        Message m;
        List<Map<String,Object>> list =  daoTemp.findAll(entity);
        if (null != list && !list.isEmpty()) {
            m = MessageProxy.success(OperationTypeEnum.FIND,list);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.FIND);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findCondPage",produces = "application/json;charset=UTF-8")
    public MessageLimit findCondPage(@RequestBody PageSelect pageSelect){
        MessageLimit msgLimit = new MessageLimit();
        AdvertisinEntity advertisinEntity = (AdvertisinEntity) ToEntity.transMapToEntity(pageSelect.getEntityMap(),AdvertisinEntity.class);
        int page = pageSelect.getPage();
        int size = pageSelect.getSize();
        List<Map<String, Object>> result = daoTemp.findLimit(advertisinEntity,page,size);
        int count = daoTemp.count(advertisinEntity,page,size);
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
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody AdvertisinEntity entity){
        Message m;

        if (0 != daoTemp.insert(entity)) {
            m = MessageProxy.success(OperationTypeEnum.ADD);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.ADD);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(@RequestBody AdvertisinEntity entity){
        Message m;

        if (0 != daoTemp.update(entity)) {
            m = MessageProxy.success(OperationTypeEnum.MODIFY);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.MODIFY);
        }
        return m;
    }
    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public Message delete(@RequestBody AdvertisinEntity entity){
        Message m;

        if (0 != daoTemp.delete(entity)) {
            m = MessageProxy.success(OperationTypeEnum.DELETE);
        } else {
            m = MessageProxy.fail(OperationTypeEnum.DELETE);
        }
        return m;
    }

}
