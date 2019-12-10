package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IRefundCauseDao;
import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.service.order.IRefundCauseService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IRefundCauseServiceImpl implements IRefundCauseService {
    @Autowired
    private IRefundCauseDao iRefundCauseDao;

    /**
     * 通过修改退货退款申请表status修改订单状态
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public Msg updateStatus(RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        if (refundCauseEntity.getStatus() == "1") {
            int up = iRefundCauseDao.updateStatus1(refundCauseEntity);
            if (up > 0) {
                msg = new Msg(0, "操作成功，同意");
            } else {
                msg = new Msg(1, "操作失败");
            }
        } else if (refundCauseEntity.getStatus() == "2") {
            int up = iRefundCauseDao.updateStatus2(refundCauseEntity);
            if (up > 0) {
                msg = new Msg(0, "操作成功，驳回");
            } else {
                msg = new Msg(1, "操作失败");
            }
        }
        return msg;
    }

    /**
     * 添加退货退款申请表
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public Msg add(RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        if (0 != refundCauseEntity.getOrderId()) {
            int result = iRefundCauseDao.insert(refundCauseEntity);
            if (0 != result) {
                msg = new Msg(0, "添加成功");
            }
        } else {
            msg = new Msg(1, "订单ID不能为空");
        }
        return msg;
    }

    /**
     * 查找所有的退货退款申请表
     *
     * @return
     */
    @Override
    public Map<String, Object> findAll(Map<String, Object> param) {
        Msg msg = null;
        int page = 0;
        int size = 0;
        String types = null;
        Map<String, Object> map = new TreeMap<>();
        try {
            page = Integer.parseInt(param.get("page").toString());
            size = Integer.parseInt(param.get("size").toString());
            types = String.valueOf(param.get("type"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("1".equals(types) || "2".equals(types)) {
            String type = types;
            PageList pageList = new PageList();
            //处理int类型的变量为空时
            if (page == 0) {
                page = 1;
            }
            if (size == 0) {
                page = 30;
            }
            List<Map<String, Object>> list = iRefundCauseDao.queryAll(page, size, type);
            pageList.setRows(list);

            //把查询出来的对象封装在分页实体类中
            if (null == list && list.isEmpty()) {
                msg = new Msg(1, "订单信息不存在");
            } else {

                //统计所有数据的总行数
                int totalRows = iRefundCauseDao.countAll();

                //把页数封装在分页实体类中
                pageList.setPage(page);
                pageList.setTotal(list.size());
                //查询出来的总行数封装在分页实体类中
                pageList.setTotalRows(totalRows);
                msg = getPages(size, pageList, totalRows);
//                map.put("code", msg.getCode());
//                map.put("massage", msg.getMsg());
                map.put("rows", list);
                map.put("total", list.size());
//                map.put("",msg);

            }
        } else {
            map.put("code", "1");
            map.put("message", "处理失败");
        }


        return map;
    }


    /**
     * 根据退货退款申请表id 查询
     *
     * @param id
     * @return
     */
    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            RefundCauseEntity byId = iRefundCauseDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0, "查询成功", byId);
            } else {
                msg = new Msg(1, "该退货退款订单不存在");
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
            int i = iRefundCauseDao.deleteById(id);
            if (i > 0) {
                msg = new Msg(0, "删除成功");
            } else {
                msg = new Msg(1, "删除失败,该退款退货订单不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");

        }
        return msg;
    }

    /**
     * 根据退货退款申请表id 修改
     *
     * @param refundCauseEntity
     * @return
     */
    @Override
    public Msg update(RefundCauseEntity refundCauseEntity) {
        int id = refundCauseEntity.getId();
        Msg msg = null;
        //先获取id
        if (id > 0) {
            //根据id查询数据
            RefundCauseEntity byId = iRefundCauseDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iRefundCauseDao.update(refundCauseEntity);
                if (result > 0) {
                    msg = new Msg(0, "修改成功");
                }
            } else {
                msg = new Msg(1, "该退货退款订单不存在");
            }
        } else {
            msg = new Msg(1, "请输入id");
        }
        return msg;
    }

    /**
     * 统计所有数据
     *
     * @return
     */
    @Override
    public int countAll() {
        return iRefundCauseDao.countAll();
    }

    /**
     * 提取公共方法
     *
     * @param size
     * @param pageList
     * @param totalRows 总记录数
     * @return
     */
    private Msg getPages(int size, PageList pageList, int totalRows) {
        Msg msg;
        int pages = 0;
        if (totalRows % size == 0) {
            pages = totalRows / size;
        } else {
            pages = totalRows / size + 1;
        }
        System.out.println("目前分页的总页数是" + pages);
        //总页数
        pageList.setPages(pages);
        msg = new Msg(0,"查询成功",pageList);
        return msg;
    }
}
