package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.PageMap;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;


    /**
     * 添加订单详细
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody OrderEntity orderEntity) {
        Msg msg=null;
        if (null != orderEntity.getUsername() && orderEntity.getUsername().trim() != "") {
            int result = iOrderService.add(orderEntity);
            if (0 != result) {
                msg = Msg.success().messageData(orderEntity);
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        return msg;
    }

    @PostMapping(value = "/findPage", produces = "application/json;charset=UTF-8")
    public Msg list(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int page = param.get("page");
        int size = param.get("size");
        PageMap pageMap = new PageMap();
        //处理int类型的变量为空时
        if (page == 0) {
            page = 1;
        }
        if (size == 0) {
            page = 30;
        }

        Map<String, Object> list = iOrderService.list(page, size);
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
        }
        return msg;
    }

    @PostMapping(value = "/batchFindAll", produces = "application/json;charset=UTF-8")
    public Msg list2(@RequestBody Map<String, String> param) {
        Msg msg = null;
        String ids = param.get("ids");
        if("".equals(ids)){
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

    @PostMapping(value = "/batchSendSubmit", produces = "application/json;charset=UTF-8")
    public Msg batchSendSubmit(@RequestBody Map<String, String> param) {
        Msg msg = null;

        Object shippingName = param.get("shippingName");
        Object shippingCode = param.get("shippingCode");
        Object orderId = param.get("orderId");
        int id = Integer.parseInt(String.valueOf(orderId));
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
        return msg;

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
