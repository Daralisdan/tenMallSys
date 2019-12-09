package com.cn.wanxi.mall.controller.advertisin;

import com.cn.wanxi.entity.advertisin.AdvertisinEntity;
import com.cn.wanxi.service.advertisin.IAdvertisinService;
import com.cn.wanxi.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping(value = "/findAll", produces = "application/json;charset=UTF-8")
    public Message findAll() {
        Message m = new Message();
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        List<AdvertisinEntity> list = iAdvertisinService.findAdvertisinAll();
        result.put("rows",list);
        result.put("total",list.size());
        if (0 < list.size()) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
            m.setData(result);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findTypeAll", produces = "application/json;charset=UTF-8")
    public Message findTypeAll(@RequestBody Map<String,String> args) {
        String position = args.get("position");
        Message m = new Message();
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        List<AdvertisinEntity> list = iAdvertisinService.findByPosition(position);
        result.put("rows",list);
        result.put("total",list.size());
        if (0 < list.size()) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
            m.setData(result);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Message findById(@RequestBody Map<String,String> args) {
        Integer id = Integer.parseInt(args.get("id"));
        Message m = new Message();
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        AdvertisinEntity entity = iAdvertisinService.findById(id);
        ArrayList<AdvertisinEntity> list = new ArrayList<>();
        list.add(entity);
        result.put("rows",list);
        result.put("total",list.size());
        if (null != entity) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
            m.setData(result);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/findCondPage", produces = "application/json;charset=UTF-8")
    public Message findCondPage(@RequestBody Map<String,String> args) {
        Integer page = Integer.parseInt(args.get("page"));
        Integer size = Integer.parseInt(args.get("size"));
        String position = args.get("position");
        Message m = new Message();
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        List<AdvertisinEntity> list = iAdvertisinService.findCondPage(page, size, position);
        result.put("rows",list);
        result.put("total",iAdvertisinService.findCondPageSum(position));
        if (0 < list.size()) {
            m.setCode(0);
            m.setMessage("查询成功");
            m.setData(result);
        } else {
            m.setCode(1);
            m.setMessage("查询失败");
            m.setData(result);
        }
        return m;
    }

    /**
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Message add(@RequestBody Map<String,String> args) {
        String position = args.get("position");
        String name = args.get("name");
        String startTime = args.get("startTime");
        String endTime = args.get("endTime");
        String status = args.get("status");
        String image = args.get("image");
        String url = args.get("url");
        String remarks = args.get("remarks");

        Message m = new Message();
        if(null == position || null == name || null == startTime || null == endTime ||
                null == status || null == image || null == url || null == remarks){
            m.setCode(1);
            m.setMessage("添加失败,不允许有字段为空");
        }

        boolean isSuccess = iAdvertisinService.add(position, name, startTime, endTime,status, image, url, remarks);
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
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Message update(@RequestBody Map<String,String> args) {
        String position = args.get("position");
        String name = args.get("name");
        String startTime = args.get("startTime");
        String endTime = args.get("endTime");
        String status = args.get("status");
        String image = args.get("image");
        String url = args.get("url");
        String remarks = args.get("remarks");
        Integer id = Integer.parseInt(args.get("id"));

        Message m = new Message();
        if(null == position || null == name || null == startTime || null == endTime ||
                null == status ||null == image || null == url || null == remarks || null == id){
            m.setCode(1);
            m.setMessage("添加失败,不允许有字段为空");
            return m;
        }
        boolean isSuccess = iAdvertisinService.update(position, name, startTime, endTime,status, image, url, remarks, id);
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
     * 【管理员查找全部】
     *
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Message delete(@RequestBody Map<String,String> args) {
        Integer id = Integer.parseInt(args.get("id"));

        Message m = new Message();
        boolean isSuccess = iAdvertisinService.delete(id);
        if (isSuccess) {
            m.setCode(0);
            m.setMessage("删除成功");
        } else {
            m.setCode(1);
            m.setMessage("删除失败");
        }
        return m;
    }
}
