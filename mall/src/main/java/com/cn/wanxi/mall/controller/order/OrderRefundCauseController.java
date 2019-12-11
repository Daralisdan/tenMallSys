package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.service.order.IRefundCauseService;
import com.cn.wanxi.service.order.IReturnCauseService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.PageList;
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
import java.util.TreeMap;

@RestController
@RequestMapping("/refund")
public class OrderRefundCauseController {
    @Autowired
    private IRefundCauseService iRefundCauseService;
    @Autowired
    private IReturnCauseService iReturnCauseService;

    @PostMapping(value = "/findAll", produces = "application/json;charset=UTF-8")
    public Map<String, Object> refundList(@RequestBody Map<String, Object> param) {
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
            List<Map<String, Object>> list = iRefundCauseService.findAll(page, size, type);
            pageList.setRows(list);

            //把查询出来的对象封装在分页实体类中
            if (null == list && list.isEmpty()) {
                msg = Msg.fail().messageData("订单信息不存在");
            } else {

                //统计所有数据的总行数
                int totalRows = iRefundCauseService.countAll();

                //把页数封装在分页实体类中
                pageList.setPage(page);
                pageList.setTotal(list.size());
                //查询出来的总行数封装在分页实体类中
                pageList.setTotalRows(totalRows);
                msg = getPages(size, pageList, totalRows);
                map.put("code", msg.getCode());
                map.put("massage", msg.getMsg());
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

    @PostMapping(value = "/approval", produces = "application/json;charset=UTF-8")
    public Map<String, Object> approval(@RequestBody RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        int up = iRefundCauseService.updateStatus(refundCauseEntity);
        if (up > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("code", msg.getCode());
        map.put("message", msg.getMsg());
        return map;
    }

    /**
     * 添加退货退款申请表
     *
     * @param refundCauseEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        if (0 != refundCauseEntity.getOrderId()) {
            int result = iRefundCauseService.add(refundCauseEntity);
            if (0 != result) {
                msg = Msg.success().messageData(refundCauseEntity);
            }
        } else {
            msg = Msg.fail().messageData("订单ID不能为空");
        }
        return msg;
    }

//    /**
//     * 查找所有的退货退款申请表
//     *
//     * @return
//     */
//    @PostMapping("/findAll")
//    public Msg findAll() {
//        Msg msg;
//        Map<String, Object> list = iRefundCauseService.findAll();
//        //判断集合是否有数据，如果没有数据返回失败
//        if (list.isEmpty()) {
//            msg = Msg.fail();
//        } else {
//            msg = Msg.success().messageData(list);
//        }
//        return msg;
//    }

    /**
     * 【根据退货退款申请表id查询信息】
     *
     * @param param
     * @param response
     * @return
     */

    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            RefundCauseEntity byId = iRefundCauseService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该退货退款订单不存在");
            }
        }
        return msg;
    }

    /**
     * 【修改退货退款申请表】
     *
     * @param refundCauseEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        //先获取id
        int id = refundCauseEntity.getId();
        if (id > 0) {
            //根据id查询数据
            RefundCauseEntity byId = iRefundCauseService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iRefundCauseService.update(refundCauseEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(refundCauseEntity);
                }
            } else {
                msg = Msg.fail().messageData("该退货退款订单不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        if (id > 0) {
            int i = iRefundCauseService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该退款退货订单不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    @PostMapping(value = "/casue", produces = "application/json;charset=UTF-8")

    public Msg casue(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            ReturnCauseEntity byId = iReturnCauseService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该原因不存在");
            }
        }
        return msg;
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
        msg = Msg.success().messageData(pageList);
        return msg;
    }

}
