package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseItemDao;
import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IRefundCauseItemImpl implements IRefundCauseItemDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 添加退货退款申请明细
     *
     * @param refundCauseItemEntity
     * @return
     */
    @Override
    public int insert(RefundCauseItemEntity refundCauseItemEntity) {
        String exeSQL = "INSERT INTO wx_tab_return_order_item(category_id,spu_id,sku_id,order_id,order_item_id,return_order_id,title,price,num,money,pay_money,image,weight) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {refundCauseItemEntity.getCategoryId(), refundCauseItemEntity.getSpuId(), refundCauseItemEntity.getSkuId(), refundCauseItemEntity.getOrderId(),
                refundCauseItemEntity.getOrderItemId(), refundCauseItemEntity.getReturnOrderId(), refundCauseItemEntity.getTitle(), refundCauseItemEntity.getPrice(), refundCauseItemEntity.getNum(),
                refundCauseItemEntity.getMoney(), refundCauseItemEntity.getPayMoney(), refundCauseItemEntity.getImage(), refundCauseItemEntity.getWeight()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有的退货退款申请明细
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select id, category_id as categoryId , spu_id as spuId , sku_id as skuId , order_id as orderId ,  order_item_id as orderItemId ,  return_order_id as returnOrderId, title,price,num,money, pay_money as payMoney ,image,weight   from wx_tab_return_order_item";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public RefundCauseItemEntity findById(int id) {
        RefundCauseItemEntity refundCauseItemEntity = null;
        String exeSQL = "select id, category_id as categoryId , spu_id as spuId , sku_id as skuId , order_id as orderId ,  order_item_id as orderItemId ,  return_order_id as returnOrderId, title,price,num,money, pay_money as payMoney ,image,weight from wx_tab_return_order_item where id=?";
        List<RefundCauseItemEntity> refundCauseItemEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<RefundCauseItemEntity>(RefundCauseItemEntity.class));
        if (null != refundCauseItemEntities && refundCauseItemEntities.size() > 0) {
            refundCauseItemEntity = refundCauseItemEntities.get(0);
        }
        return refundCauseItemEntity;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_return_order_item WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    @Override
    public int update(RefundCauseItemEntity refundCauseItemEntity) {
        String exeSQL = "update wx_tab_return_order_item set category_id=? ,spu_id=?,sku_id=?,order_id=?,order_item_id=?,return_order_id=?,title=?, price=?,num=?,money=?,pay_money=?," +
                "image=?,weight=? WHERE id=?";
        Object args[] = {refundCauseItemEntity.getCategoryId(), refundCauseItemEntity.getSpuId(), refundCauseItemEntity.getSkuId(), refundCauseItemEntity.getOrderId(), refundCauseItemEntity.getOrderItemId(),
                refundCauseItemEntity.getReturnOrderId(), refundCauseItemEntity.getTitle(), refundCauseItemEntity.getPrice(), refundCauseItemEntity.getNum(), refundCauseItemEntity.getMoney(), refundCauseItemEntity.getPayMoney(),
                refundCauseItemEntity.getImage(), refundCauseItemEntity.getWeight(), refundCauseItemEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }
}
