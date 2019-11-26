package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseDao;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.service.order.IRefundCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class IRefundCauseServiceImpl implements IRefundCauseService {
    @Autowired
    private IRefundCauseDao iRefundCauseDao;

    /**
     * 通过修改退货退款申请表status修改订单状态
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int updateStatus(RefundCauseEntity refundCauseEntity) {
        int up=0;
        if ("1".equals(refundCauseEntity.getStatus())) {
            up= iRefundCauseDao.updateStatus1(refundCauseEntity);
        } else if ("2".equals(refundCauseEntity.getStatus())) {
           up= iRefundCauseDao.updateStatus2(refundCauseEntity);
        }else {
            System.out.println("订单申请状态有误，请重新输入!");
        }

        return up;
    }
    @Override
    public List<Map<String, Object>> refundList(int page, int size) {
        return iRefundCauseDao.refundList(page, size);
    }
    /**
     * 添加退货退款申请表
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int add(RefundCauseEntity refundCauseEntity) {
        //判断页面传的值中orderid不能为空
        Integer orderid = refundCauseEntity.getOrderId();
        int result = 0;
        //不为空时，添加数据
        if (!StringUtils.isEmpty(orderid)) {
            result = iRefundCauseDao.insert(refundCauseEntity);
        }
        return result;
    }
    /**
     * 查找所有的退货退款申请表
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return iRefundCauseDao.queryAll();
    }
    /**
     * 根据退货退款申请表id 查询
     * @param id
     * @return
     */
    @Override
    public RefundCauseEntity findById(int id) {
        return iRefundCauseDao.findById(id);
    }
    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return iRefundCauseDao.deleteById(id);
    }
    /**
     * 根据退货退款申请表id 修改
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int update(RefundCauseEntity refundCauseEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = refundCauseEntity.getId();
        RefundCauseEntity byId = iRefundCauseDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iRefundCauseDao.update(refundCauseEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
}
