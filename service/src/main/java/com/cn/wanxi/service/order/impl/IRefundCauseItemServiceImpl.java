package com.cn.wanxi.service.order.impl;


import com.cn.wanxi.dao.order.IRefundCauseItemDao;
import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import com.cn.wanxi.service.order.IRefundCauseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class IRefundCauseItemServiceImpl  implements IRefundCauseItemService {
    @Autowired
    private IRefundCauseItemDao iRefundCauseItemDao;

    /**
     * 添加退货退款申请明细表
     * @param refundCauseItemEntity
     * @return
     */
    @Override
    public int add(RefundCauseItemEntity refundCauseItemEntity) {
        //判断页面传的值中orderid不能为空
        Integer orderid = refundCauseItemEntity.getOrderId();
        int result = 0;
        //不为空时，添加数据
        if (!StringUtils.isEmpty(orderid)) {
            result = iRefundCauseItemDao.insert(refundCauseItemEntity);
        }
        return result;
    }

    /**
     * 查找所有的退货退款申请明细表
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll() {
        return iRefundCauseItemDao.queryAll();
    }
    /**
     * 根据退货退款申请明细表id 查询
     * @param id
     * @return
     */

    @Override
    public RefundCauseItemEntity findById(int id) {
        return iRefundCauseItemDao.findById(id);
    }
    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
         return iRefundCauseItemDao.deleteById(id);
    }
    /**
     * 根据退货退款申请明细表id 修改
     * @param refundCauseItemEntity
     * @return
     */
    @Override
    public int update(RefundCauseItemEntity refundCauseItemEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = refundCauseItemEntity.getId();
        RefundCauseItemEntity byId = iRefundCauseItemDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = iRefundCauseItemDao.update(refundCauseItemEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
}
