package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.entity.order.PageMap;
import com.cn.wanxi.service.order.IOrderItemService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.models.auth.In;
import net.minidev.json.JSONUtil;
import net.minidev.json.parser.JSONParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderItemService iOrderItemService;


    /**
     * 添加订单详细
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Map<String, Object> add(@RequestBody OrderEntity orderEntity) {
        Msg msg = null;
        List<OrderItemEntity> sublist = orderEntity.getSublist();
        if (null != orderEntity.getUsername() && orderEntity.getUsername().trim() != ""

        ) {
            int result = iOrderService.add(orderEntity);
            int result2 = iOrderItemService.add(sublist);
            if (result >= 1 && result2 >= 1) {
                msg = Msg.success();
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("code", msg.getCode());
        map.put("message", msg.getMsg());
        return map;
    }

    @PostMapping(value = "/findPage", produces = "application/json;charset=UTF-8")
    public Map<String,Object> list(@RequestBody Map<String, Object> param, HttpServletResponse response) {
        Msg msg = null;
        OrderEntity orderEntity = new OrderEntity();
        Map<String,Object> map = new TreeMap<>();
        if (param.get("page") == null && param.get("size") == null) {
            msg = Msg.fail().messageData("请输入正确的page或者size");
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
            String orderStatus = String.valueOf(param.get("orderStatus"));
            orderEntity.setOrderStatus(orderStatus);
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


        Map<String, Object> list = iOrderService.list(page, size, orderEntity);

        //把查询出来的对象封装在分页实体类中
        pageMap.setMap(list);
        if (null == list && list.isEmpty()) {
            msg = Msg.fail().messageData("订单信息不存在");
        } else {

            //统计所有数据的总行数
            int TotalRows = iOrderService.countAll();

            //把页数封装在分页实体类中
            pageMap.setPage(page);
            pageMap.setTotal(list.size());
            //查询出来的总行数封装在分页实体类中
            pageMap.setTotalRows(TotalRows);
            msg = getPages(size, pageMap, TotalRows);
//            map.put("total",list.size());
            list.put("total",TotalRows);

        }
        return list;
    }

    @PostMapping(value = "/batchFindAll", produces = "application/json;charset=UTF-8")
    public Msg list2(@RequestBody Map<String, String> param) {
        Msg msg = null;
        String ids = param.get("ids");
        if ("".equals(ids)) {
            msg = Msg.fail().messageData("格式不对");
        } else {
            Map<String, Object> list = iOrderService.batchlist(ids);

            //判断集合是否有数据，如果没有数据返回失败
            if (!ObjectUtils.isEmpty(list)) {
                msg = Msg.success().messageData(list);
            } else {
                msg = Msg.fail().messageData("不存在");
            }
        }

        return msg;
    }

    /**
     * 批量发货提交
     *
     * @param orderEntitiestr
     * @return
     */

    @PostMapping(value = "/batchSendSubmit", produces = "application/json;charset=UTF-8")
    public Map<String, Object> batchSendSubmit(@RequestBody String orderEntitiestr) {
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
                OrderEntity byId = iOrderService.findById(id);
                //判断是否查询到该品牌信息
                if (!ObjectUtils.isEmpty(byId)) {
                    int result = iOrderService.batchSendSubmit(id, orderId, shippingName, shippingCode);
                    if (result > 0) {
                        msg = Msg.success();
                    }
                } else {
                    msg = Msg.fail().messageData("该订单不存在");
                }
            } else {
                msg = Msg.fail().messageData("输入格式有误");
            }
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("code", msg.getCode());
        map.put("message", msg.getMsg());

        return map;
    }
//    @PostMapping("/findbyorderid")
//    public Msg findByOrderId(int orderId) {
//        Msg msg = null;
//        OrderLogEntity byOrderId = iOrderService.findByOrderId(orderId);
//        if (byOrderId != null) {
//            msg = Msg.success().messageData("order", byOrderId);
//        } else {
//            msg = Msg.fail();
//        }
//        return msg;
//    }

    /**
     * 根据订单主表id查询信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/findbyid", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderEntity byId = iOrderService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该订单不存在");
            }
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderEntity orderEntity) {
        Msg msg = null;
        int id = orderEntity.getId();
        if (id > 0) {
            int i = iOrderService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该用户不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }


    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
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

    /**
     * 【test】
     *
     * @param list
     * @return
     */
    @PostMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public Msg test(@RequestBody List<Map<String,String>> list) {



        int a = 10;

        return new Msg();
    }

//    @PostMapping(value = "/test", produces = "application/json;charset=UTF-8")
//    public Map<String, Object> test(@RequestBody Map<String, String> param) {
//        Msg msg = null;
//        String ids = param.get("ids");
//        if ("".equals(ids)) {
//            msg = Msg.fail().messageData("aaa");
//        } else {
//            ids = "aa,sss,,ddds,io";
//            String[] idList = ids.split(",");
//            Integer.parseInt(idList[0]);
//            Map<String, Object> list = iOrderService.batchlist(ids);
//            //判断集合是否有数据，如果没有数据返回失败
//            if (list.isEmpty()) {
//                msg = Msg.fail();
//            } else {
//                msg = Msg.success().messageData(list);
//            }
//        }
//        return null;
//    }
}
