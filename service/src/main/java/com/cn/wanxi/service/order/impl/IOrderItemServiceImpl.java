package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderItemDao;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.service.order.IOrderItemService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author FENGDOU
 */
@Service
public class IOrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private IOrderItemDao iOrderItemDao;

    /**
     * 添加订单详细列表
     * @param orderItemEntityList
     * @return
     */
    @Override
    public int add(List<OrderItemEntity> orderItemEntityList) {

        return iOrderItemDao.insert(orderItemEntityList);
    }

    /**
     * 查找所有的订单详细
     * @return
     */
    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderItemDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = new Msg(1,"查询失败");
        } else {
            msg = new Msg(0,"查询成功",list);
        }
        return msg;
    }

    /**
     * 根据订单详细id 查询
     * @param id
     * @return
     */
    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderItemEntity byId = iOrderItemDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0,"查询成功",byId);
            } else {
                msg = new Msg(1,"该订单详情不存在");
            }
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public Msg deleteById(int id) {
        Msg msg = null;
        if (id > 0) {
            int i = iOrderItemDao.deleteById(id);
            if (i > 0) {
                msg = new Msg(0,"删除成功");
            } else {
                msg = new Msg(1,"删除失败,该订单详细不存在");
            }
        } else {
            msg =new Msg(1,"请输入id");
        }
        return msg;
    }

    /**
     * 根据订单详细id 修改
     * @param orderItemEntity
     * @return
     */
    @Override
    public Msg update(OrderItemEntity orderItemEntity) {
        int id = orderItemEntity.getId();
        Msg msg = null;
        //先获取id
        if (id > 0) {
            //根据id查询数据
            OrderItemEntity byId = iOrderItemDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iOrderItemDao.update(orderItemEntity);
                if (result > 0) {
                    msg = new Msg(0,"修改成功");
                }
            } else {
                msg = new Msg(1,"该订单详情不存在");
            }
        } else {
            msg = new Msg(1,"请输入id");
        }
        return msg;
    }




}
