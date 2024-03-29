package com.cn.wanxi.dao.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseDao;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.utils.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class IRefundCauseImpl implements IRefundCauseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id修改退货退款订单的状态为1，记录当前管理员id和当前时间，同意退款
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int updateStatus1(RefundCauseEntity refundCauseEntity) {
        String sql = "update wx_tab_return_order set status=? , dispose_time=? where id=?";
        String sql1 = "update wx_tab_order set pay_status= '2' where id=  'select order_id from wx_tab_return_order where id=" + refundCauseEntity.getId() + "'";
        String sql2 = "update wx_tab_order_item set is_return= '2' where id=  'select order_id from wx_tab_return_order where id=" + refundCauseEntity.getId() + "'";
        Object args[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getId()};
        int temp = jdbcTemplate.update(sql, args);
        jdbcTemplate.update(sql1);
        jdbcTemplate.update(sql2);
        return temp;
    }

    /**
     * 根据id修改退货退款订单的状态为2，记录当前管理员id、当前时间和驳回理由,驳回退款
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int updateStatus2(RefundCauseEntity refundCauseEntity) {
        String sql = "update wx_tab_return_order set status=? , dispose_time=? , remark=? where id=?";
        String sql2 = "update wx_tab_order_item set is_return= '0' where id=  'select order_id from wx_tab_return_order where id=" + refundCauseEntity.getId() + "'";
        Object args[] = {refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), "驳回理由：SSS", refundCauseEntity.getId()};
        int temp = jdbcTemplate.update(sql, args);
        jdbcTemplate.update(sql2);
        return temp;
    }


//    /**
//     * 根据page和size分页查询所有的待退款审批列表
//     *
//     * @param page
//     * @param size
//     * @return
//     */
//    @Override
//    public Map<String, Object> refundList(int page, int size,String type) {
//
//        String exeSQL = "select id, order_id as orderId , apply_time as applyTime , user_id as userId, user_account as userAccount ,linkman , linkman_mobile as linkmanMobile ,type, return_money as returnMoney , is_return_freight as isReturnFreight,status, dispose_time as disposeTime  ,  return_cause as returnCause ,evidence,description,remark, admin_id as adminId   from wx_tab_return_order where type = "+type+" limit " + (page - 1) * size + " , " + size;
//
////        map=jdbcTemplate.queryForMap(exeSQL,);
//
//        Map<String, Object> list = jdbcTemplate.queryForMap(exeSQL);
//
//
//        return list;
//    }

    /**
     * 添加待退款订单
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int insert(RefundCauseEntity refundCauseEntity) {
        String exeSQL = "INSERT INTO wx_tab_return_order(order_id,apply_time,user_id,user_account,linkman,linkman_mobile,type,return_money,is_return_freight,status,dispose_time,return_cause,evidence,description,remark,admin_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {refundCauseEntity.getOrderId(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getUserId(), refundCauseEntity.getUserAccount(), refundCauseEntity.getLinkman(), refundCauseEntity.getLinkmanMobile(), refundCauseEntity.getType(),
                refundCauseEntity.getReturnMoney(), refundCauseEntity.getIsReturnFreight(), refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getReturnCause(), refundCauseEntity.getEvidence(), refundCauseEntity.getDescription(), refundCauseEntity.getRemark(), refundCauseEntity.getAdminId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    /**
     * 查找所有退货退款申请表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAll(int page, int size, String type) {
//        Map<String, Object> map = new LinkedHashMap<>();
        String exeSQL = "select id,  order_id as orderId ,  DATE_FORMAT(apply_time,'%Y-%m-%d %H:%i:%s') as applyTime , user_id as userId, user_account as userAccount ,linkman , linkman_mobile as linkmanMobile ,type, return_money as returnMoney , is_return_freight as isReturnFreight,status,  DATE_FORMAT(dispose_time,'%Y-%m-%d %H:%i:%s')  as disposeTime  ,  return_cause as returnCause ,evidence,description,remark, admin_id as adminId    from wx_tab_return_order where type = " + type + " and status='0' limit " + (page - 1) * size + " , " + size;
//                "limit" + (page - 1) * size + " , " + size;
//                "limit " + (page - 1) * size + " , " + size;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
//        map.put("rows",list);
        return list;
    }

    /**
     * 根据id查询退货退款申请表
     *
     * @param id
     * @return
     */

    @Override
    public RefundCauseEntity findById(int id) {
        RefundCauseEntity refundCauseEntity = null;
        String exeSQL = "select id, order_id as orderId , DATE_FORMAT(apply_time,'%Y-%m-%d %H:%i:%s') as applyTime , user_id as userId, user_account as userAccount ,linkman , linkman_mobile as linkmanMobile ,type, return_money as returnMoney , is_return_freight as isReturnFreight,status,  DATE_FORMAT(dispose_time,'%Y-%m-%d %H:%i:%s') as disposeTime  ,  return_cause as returnCause ,evidence,description,remark, admin_id as adminId   from wx_tab_return_order where id=?";
        List<RefundCauseEntity> refundCauseEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<RefundCauseEntity>(RefundCauseEntity.class));
        if (null != refundCauseEntities && refundCauseEntities.size() > 0) {
            refundCauseEntity = refundCauseEntities.get(0);
        }
        return refundCauseEntity;
    }

    /**
     * 根据id删除退货退款申请表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_return_order WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }

    /**
     * 修改退货退款申请表
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public int update(RefundCauseEntity refundCauseEntity) {
        String exeSQL = "update wx_tab_return_order set order_id=?,apply_time=?,user_id=?,user_account=?,linkman=?,linkman_mobile=?,type=?,return_money=?,is_return_freight=?,status=?,dispose_time=?,return_cause=?,evidence=?,description=?,remark=?,admin_id=?  WHERE id=?";
        Object args[] = {refundCauseEntity.getOrderId(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getUserId(), refundCauseEntity.getUserAccount(), refundCauseEntity.getLinkman(), refundCauseEntity.getLinkmanMobile(), refundCauseEntity.getType(),
                refundCauseEntity.getReturnMoney(), refundCauseEntity.getIsReturnFreight(), refundCauseEntity.getStatus(), UtilsHelper.formatDateTimer(new Date()), refundCauseEntity.getReturnCause(), refundCauseEntity.getEvidence(), refundCauseEntity.getDescription(),
                refundCauseEntity.getRemark(), refundCauseEntity.getAdminId(), refundCauseEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }


    /**
     * 【统计查询数据库所有数据】
     *
     * @return
     */
    @Override
    public int countAll() {
        String sql = "select * from wx_tab_return_order";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, countCallback);
        int count = countCallback.getRowCount();
        System.out.println("目前的总条数是" + count);
        return count;
    }

}
