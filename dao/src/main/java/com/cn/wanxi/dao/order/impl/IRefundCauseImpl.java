package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseDao;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.entity.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class IRefundCauseImpl implements IRefundCauseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updateStatus1(RefundCauseEntity refundCauseEntity) {
        String sql = "update wx_tab_return_order set status=? , dispose_time=? where id=?";

        Object args[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getId()};
        int temp = jdbcTemplate.update(sql, args);
        return temp;
    }


    @Override
    public int updateStatus2(RefundCauseEntity refundCauseEntity) {
        String sql = "update wx_tab_return_order set status=? , dispose_time=? , remark=? where id=?";
        Object args[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), "驳回理由：SSS",refundCauseEntity.getId()};
        int temp = jdbcTemplate.update(sql, args);
        return temp;
    }
}
