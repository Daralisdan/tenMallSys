package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IReturnCauseDao;
import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.service.order.IReturnCauseService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IReturnCauseServiceImpl implements IReturnCauseService {
    @Autowired
    private IReturnCauseDao iReturnCauseDao;


    /**
     * 【根据id修改】
     *
     * @param returnCauseEntity
     * @return
     */
    @Override
    public Msg update(ReturnCauseEntity returnCauseEntity) {
        Msg msg = null;
        //先获取id
        int id = returnCauseEntity.getId();
        if (id > 0) {
            //根据id查询数据
            ReturnCauseEntity byId = iReturnCauseDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iReturnCauseDao.update(returnCauseEntity);
                if (result > 0) {
                    msg = new Msg(0,"修改成功");
                }
            } else {
                msg = new Msg(1,"该原因不存在");
            }
        } else {
            msg = new Msg(1,"请输入id");
        }
//        Map<String, Object> map = new TreeMap<>();
//        map.put("code", msg.getCode());
//        map.put("message", msg.getMsg());
        return msg;
    }


    /**
     * 【根据id查询】
     *
     * @param id
     * @return
     */
    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            ReturnCauseEntity byId = iReturnCauseDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0, "查询成功");
            } else {
                msg = new Msg(1, "该原因不存在");
            }
        }
        return msg;

    }

    @Override
    public Msg add(ReturnCauseEntity returnCauseEntity) {
        Msg msg=null;
        if (null != returnCauseEntity.getCause() && returnCauseEntity.getCause() .trim() != "") {
            int result = iReturnCauseDao.insert(returnCauseEntity);
            if (0 != result) {
                msg =new Msg(0,"添加成功");
            }
        } else {
            msg =new Msg(1,"原因不能为空");
        }
//        Map<String,Object> map = new TreeMap<>();
//        map.put("code",msg.getCode());
//        map.put("message",msg.getMsg());
        return msg;
    }

    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iReturnCauseDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = new Msg(1, "没有数据");
        } else {
            msg = new Msg(0, "查询成功", list);
        }
        return msg;
    }

    @Override
    public Msg deleteById(int id) {
        Msg msg = null;
        if (id > 0) {
            int i = iReturnCauseDao.deleteById(id);
            if (i > 0) {
                msg=new Msg(0,"删除成功");
            } else {
                msg=new Msg(1,"删除失败,该原因不存在");
            }
        } else {
            msg=new Msg(1,"请输入id");
        }
//        Map<String, Object> map = new TreeMap<>();
//        map.put("code", msg.getCode());
//        map.put("message", msg.getMsg());
        return msg;
    }
}
