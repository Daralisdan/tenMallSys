package com.cn.wanxi.service.order.impl;


import com.cn.wanxi.dao.order.IRefundCauseItemDao;
import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import com.cn.wanxi.service.order.IRefundCauseItemService;
import com.cn.wanxi.utils.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class IRefundCauseItemServiceImpl implements IRefundCauseItemService {
    @Autowired
    private IRefundCauseItemDao iRefundCauseItemDao;

    /**
     * 添加退货退款申请明细表
     *
     * @param refundCauseItemEntity
     * @return
     */
    @Override
    public Msg add(RefundCauseItemEntity refundCauseItemEntity) {
        Msg msg = null;
        if (0 != refundCauseItemEntity.getOrderId()) {
            int result = iRefundCauseItemDao.insert(refundCauseItemEntity);
            if (0 != result) {
                msg = new Msg(0, "添加成功");
            }
        } else {
            msg = new Msg(1, "退货退款申请明细ID不能为空");
        }
        return msg;
    }

    /**
     * 查找所有的退货退款申请明细表
     *
     * @return
     */
    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iRefundCauseItemDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = new Msg(1, "没有数据");
        } else {
            msg = new Msg(0, "查询成功", list);
        }
        return msg;
    }

    /**
     * 根据退货退款申请明细表id 查询
     *
     * @param id
     * @return
     */

    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            RefundCauseItemEntity byId = iRefundCauseItemDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0, "查询成功", byId);
            } else {
                msg = new Msg(1, "该退货退款明细不存在");
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
            int i = iRefundCauseItemDao.deleteById(id);
            if (i > 0) {
                msg = new Msg(0, "删除成功");
            } else {
                msg = new Msg(1, "删除失败,该退货退款明细不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");
        }
        return msg;
    }

    /**
     * 根据退货退款申请明细表id 修改
     *
     * @param refundCauseItemEntity
     * @return
     */
    @Override
    public Msg update(RefundCauseItemEntity refundCauseItemEntity) {
        Msg msg = null;
        //先获取id
        int id = refundCauseItemEntity.getId();
        if (id > 0) {
            //根据id查询数据
            RefundCauseItemEntity byId = iRefundCauseItemDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iRefundCauseItemDao.update(refundCauseItemEntity);
                if (result > 0) {
                    msg = new Msg(0, "修改成功");
                }
            } else {
                msg = new Msg(1, "该退货退款明细不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");
        }
        return msg;
    }
}
