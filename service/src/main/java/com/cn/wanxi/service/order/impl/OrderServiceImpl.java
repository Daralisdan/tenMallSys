package com.cn.wanxi.service.order.impl;

import com.cn.wanxi.dao.order.IOrderDao;
import com.cn.wanxi.dao.order.IOrderItemDao;
import com.cn.wanxi.entity.order.*;
import com.cn.wanxi.service.order.IOrderService;
import com.cn.wanxi.utils.utils.Msg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2019/11/18,Create by yaodan
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;
    @Autowired
    private IOrderItemDao iOrderItemDao;

    @Override
    public Msg add(OrderEntity orderEntity) {
        Msg msg = null;
        List<OrderItemEntity> sublist = orderEntity.getSublist();
        if (null != orderEntity.getUsername() && orderEntity.getUsername().trim() != ""

        ) {
            int result = iOrderDao.insert(orderEntity);
            int result2 = iOrderItemDao.insert(sublist);
            if (result >= 1 && result2 >= 1) {
                msg = new Msg(0, "新增成功");
            }
        } else {
            msg = new Msg(1, "新增失败");
        }
//        Map<String, Object> map = new TreeMap<>();
//        map.put("code", msg.getCode());
//        map.put("message", msg.getMsg());
        return msg;
    }

    @Override
    public Msg update() {
        Msg msg = null;
        iOrderDao.update();
        msg=new Msg(0, "修改成功");
        return msg;
    }


    @Override
    public Msg batchlist() {
        Msg msg = null;
        Map<String, Object> list = iOrderDao.batchlist();

        //判断集合是否有数据，如果没有数据返回失败
        if (!ObjectUtils.isEmpty(list)) {
            msg = new Msg(0, "查询成功", list);
        } else {
            msg = new Msg(1, "不存在");
        }
        return msg;
    }

    @Override
    public Msg item(int id) {
        Msg msg = null;
        Map<String, Object> list = iOrderDao.item(id);

        //判断集合是否有数据，如果没有数据返回失败
        if (!ObjectUtils.isEmpty(list)) {
            msg = new Msg(0, "查询成功", list);
        } else {
            msg = new Msg(1, "不存在");
        }
        return msg;
    }

    @Override
    public Msg findById(int id) {
        Msg msg = null;
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderEntity byId = iOrderDao.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = new Msg(0, "查询成功", byId);
            } else {
                msg = new Msg(1, "查询失败");
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
            int i = iOrderDao.deleteById(id);
            if (i > 0) {
                msg = new Msg(0, "删除成功");
            } else {
                msg = new Msg(1, "删除失败,该用户不存在");
            }
        } else {
            msg = new Msg(1, "请输入用户ID");
        }
        return msg;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = new Msg(1, "查询失败");
        } else {
            msg = new Msg(0, "查询成功", list);
        }
        return msg;
    }


    @Override
    public Map<String, Object> list(Map<String, Object> param) {
        Msg msg = null;
        OrderEntity orderEntity = new OrderEntity();
        Map<String, Object> map = new TreeMap<>();
        if (param.get("page") == null && param.get("size") == null) {
            msg = new Msg(1, "请输入正确的page或者size");
        }
        int page = Integer.parseInt(String.valueOf(param.get("page")));
        int size = Integer.parseInt(String.valueOf(param.get("size")));


//        if (param.get("bgdate")!=null){
//            String bgDate = String.valueOf(param.get("bgdate"));
//            OrderEntity orderEntity =new OrderEntity();
//            orderEntity.setCreateTime(bgDate);
//        }if (param.get("eddate")!=null){
//            String edDate = String.valueOf(param.get("eddate"));
//        }
//        String edDate = String.valueOf(param.get("eddate"));
        if (param.get("username") != null) {
            String username = param.get("username").toString();
            orderEntity.setUsername(username);
        }
        if (param.get("orderStatus") != null) {
            String orderStatus1 = String.valueOf(param.get("orderStatus"));
            orderEntity.setOrderStatus(orderStatus1);
        }
        if (param.get("bgDate") != null && param.get("edDate") != null) {
            String bgDate = String.valueOf(param.get("bgDate"));
            orderEntity.setCreateTime(bgDate);
            String edDate = String.valueOf(param.get("edDate"));
            orderEntity.setEndTime(edDate);
        }
        if (param.get("bgDate") != null) {
            String bgDate = String.valueOf(param.get("bgDate"));
            orderEntity.setCreateTime(bgDate);

        }
        if (param.get("edDate") != null) {
            String edDate = String.valueOf(param.get("edDate"));
            orderEntity.setEndTime(edDate);

        }


        PageMap pageMap = new PageMap();


        Map<String, Object> list = iOrderDao.list(page, size, orderEntity);

        //把查询出来的对象封装在分页实体类中
        pageMap.setMap(list);
        if (null == list && list.isEmpty()) {
            msg = new Msg(1, "订单信息不存在");
        } else {

            //统计所有数据的总行数
            int TotalRows = iOrderDao.countAll();

            //把页数封装在分页实体类中
            pageMap.setPage(page);
            pageMap.setTotal(list.size());
            //查询出来的总行数封装在分页实体类中
            pageMap.setTotalRows(TotalRows);
//            msg = getPages(size, pageMap, TotalRows);
//            map.put("total",list.size());
            list.put("total", TotalRows);

        }
        return list;

    }

    @Override
    public Msg batchSendSubmit(String orderEntitiestr) {
        Msg msg = null;
        int id = 0;
        int orderId = 0;
        String shippingName;
        String shippingCode;

        // 转化为json格式
        JSONObject jsonObject = JSONObject.fromObject(orderEntitiestr);
        // 拿到json对象的属性
        JSONArray jsonArray = jsonObject.getJSONArray("orderEntities");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            id = jsonObject1.getInt("id");
            orderId = jsonObject1.getInt("id");
            shippingName = jsonObject1.getString("shippingName");
            shippingCode = jsonObject1.getString("shippingCode");
            if (id > 0) {
                //根据id查询数据
                OrderEntity byId = iOrderDao.findById(id);
                //判断是否查询到该订单信息
                if (!ObjectUtils.isEmpty(byId)) {
                    int result = iOrderDao.batchSendSubmit(id, orderId, shippingName, shippingCode);
                    if (result > 0) {
                        msg =new Msg(0,"批量发货成功");
                    }
                } else {
                    msg =new Msg(1,"该订单不存在");
                }
            } else {
                msg =new Msg(1,"输入格式有误");
            }
        }
//        Map<String, Object> map = new TreeMap<>();
//        map.put("code", msg.getCode());
//        map.put("message", msg.getMsg());

        return msg;
    }

    /**
     * 统计所有数据
     *
     * @return
     */
    @Override
    public int countAll() {
        return iOrderDao.countAll();
    }
    /**
     * 提取公共方法
     *
     * @param size
     * @param pageMap
     * @param totalRows 总记录数
     * @return
     */
    private Msg getPages(int size, PageMap pageMap, int totalRows) {
        Msg msg;
        int pages = 0;
        if (totalRows % size == 0) {
            pages = totalRows / size;
        } else {
            pages = totalRows / size + 1;
        }
        System.out.println("目前分页的总页数是" + pages);
        //总页数
        pageMap.setPages(pages);
        msg = Msg.success().messageData(pageMap);
        return msg;
    }
}
