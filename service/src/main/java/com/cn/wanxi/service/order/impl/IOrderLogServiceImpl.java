package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderLogDao;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.service.order.IOrderLogService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service
public class IOrderLogServiceImpl implements IOrderLogService {
    @Autowired
    private IOrderLogDao iOrderLogDao;

    /**
     * 添加订单日志列表
     *
     * @param orderLogEntity
     * @return
     */
    @Override
    public Msg add(OrderLogEntity orderLogEntity) {
        Msg msg = null;
        if (0 != orderLogEntity.getOrderId()) {
            int result = iOrderLogDao.insert(orderLogEntity);
            if (0 != result) {
                msg = new Msg(0, "添加成功");
            }
        } else {
            msg = new Msg(1, "订单id不为空");
        }
        return msg;
    }

    /**
     * 查找所有的日志详细
     *
     * @return
     */
    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderLogDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = new Msg(1, "查询失败，数据表中无数据");
        } else {
            msg = new Msg(0, "查询成功", list);
        }
        return msg;
    }

    /**
     * 根据日志详细id 查询
     *
     * @param id
     * @return
     */
    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderLogEntity byId = iOrderLogDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0, "查询成功", byId);
            } else {
                msg = new Msg(1, "该订单日志不存在");
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
            int i = iOrderLogDao.deleteById(id);
            if (i > 0) {
                msg = new Msg(0, "删除成功");
            } else {
                msg = new Msg(1, "删除失败,该日志不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");
        }
        return msg;
    }

    /**
     * 根据日志详细id 修改
     *
     * @param orderLogEntity
     * @return
     */
    @Override
    public Msg update(OrderLogEntity orderLogEntity) {
        Msg msg = null;
        int id = orderLogEntity.getId();
        //先获取id
        if (id > 0) {
            //根据id查询数据
            OrderLogEntity byId = iOrderLogDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iOrderLogDao.update(orderLogEntity);
                if (result > 0) {
                    msg = new Msg(0, "修改成功");
                }
            } else {
                msg = new Msg(1, "该订单日志不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");
        }
        return msg;
    }
}
