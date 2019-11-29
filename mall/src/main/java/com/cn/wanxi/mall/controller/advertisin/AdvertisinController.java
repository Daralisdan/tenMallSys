package com.cn.wanxi.mall.controller.advertisin;

import com.cn.wanxi.entity.advertisin.AdvertisinEntity;
import com.cn.wanxi.service.advertisin.IAdvertisinService;
import com.cn.wanxi.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeesonWong
 * @date 2019/11/26 19:49
 */
@RestController
@RequestMapping("/advertisin")
public class AdvertisinController {
    @Autowired
    private IAdvertisinService iAdvertisinService;

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public Message findAll(){
        Message m = new Message();
        List<AdvertisinEntity> list = iAdvertisinService.findAdvertisinAll();
        if(0 < list.size()){
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(list);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findTypeAll",produces = "application/json;charset=UTF-8")
    public Message findTypeAll(String position){
        Message m = new Message();
        List<AdvertisinEntity> list = iAdvertisinService.findByPosition(position);
        if(0 < list.size()){
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(list);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findById",produces = "application/json;charset=UTF-8")
    public Message findById(int id){
        Message m = new Message();
        AdvertisinEntity entity = iAdvertisinService.findById(id);
        if(null != entity){
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(entity);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findCondPage",produces = "application/json;charset=UTF-8")
    public Message findCondPage(int page,int size,String position){
        Message m = new Message();
        List<AdvertisinEntity> list = iAdvertisinService.findCondPage(page,size,position);
        if(0 < list.size()){
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(list);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Message add(String position, String name, Date startTime,Date endTime,String image,String url,String remarks){
        Message m = new Message();
        boolean isSuccess = iAdvertisinService.add(position,name,startTime,endTime,image,url,remarks);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("添加成功");
        } else {
            m.setCode(1);
            m.setMessage("添加失败");
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Message update(String position, String name, Date startTime,Date endTime,String image,String url,String remarks,int id){
        Message m = new Message();
        boolean isSuccess = iAdvertisinService.update(position,name,startTime,endTime,image,url,remarks,id);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("更新成功");
        } else {
            m.setCode(1);
            m.setMessage("更新失败");
        }
        return m;
    }
    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public Message delete(int id){
        Message m = new Message();
        boolean isSuccess = iAdvertisinService.delete(id);
        if(isSuccess){
            m.setCode(0);
            m.setMessage("删除成功");
        } else {
            m.setCode(1);
            m.setMessage("删除失败");
        }
        return m;
    }

}
