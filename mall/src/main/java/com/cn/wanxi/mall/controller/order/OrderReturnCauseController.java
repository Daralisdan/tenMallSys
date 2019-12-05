package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IReturnCauseService;
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

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/cause")
public class OrderReturnCauseController {
    @Autowired
    private IReturnCauseService iReturnCauseService;
    @PostMapping (value = "/casue" , produces = "application/json;charset=UTF-8")
    public Msg casue(@RequestBody ReturnCauseEntity returnCauseEntity) {
        Msg msg = null;
        int up = iReturnCauseService.update(returnCauseEntity);
        if (up > 0) {
            msg = Msg.success().messageData(returnCauseEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
    /**
     * 添加退货退款申请明细
     * @param returnCauseEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Map<String,Object> add(@RequestBody ReturnCauseEntity returnCauseEntity) {
        Msg msg=null;
        if (null != returnCauseEntity.getCause() && returnCauseEntity.getCause() .trim() != "") {
            int result = iReturnCauseService.add(returnCauseEntity);
            if (0 != result) {
                msg = Msg.success();
            }
        } else {
            msg = Msg.fail().messageData("原因不能为空");
        }
        Map<String,Object> map = new TreeMap<>();
        map.put("code",msg.getCode());
        map.put("message",msg.getMsg());
        return map;
    }

    /**
     * 查找所有的退货退款申请明细
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iReturnCauseService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    /**
     * 【根据退货退款申请明细id查询信息】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
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
     * 【修改退货退款申请明细信息】
     *
     * @param returnCauseEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Map<String, Object> updateInfo(@RequestBody ReturnCauseEntity returnCauseEntity) {
        Msg msg = null;
        //先获取id
        int id = returnCauseEntity.getId();
        if (id > 0) {
            //根据id查询数据
            ReturnCauseEntity byId = iReturnCauseService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iReturnCauseService.update(returnCauseEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(returnCauseEntity);
                }
            } else {
                msg = Msg.fail().messageData("该原因不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        Map<String,Object> map = new TreeMap<>();
        map.put("code",msg.getCode());
        map.put("message",msg.getMsg());
        return map;
    }


    /**
     * 【根据id删除】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Map<String, Object> deleteById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        if (id > 0) {
            int i = iReturnCauseService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该原因不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        Map<String,Object> map = new TreeMap<>();
        map.put("code",msg.getCode());
        map.put("message",msg.getMsg());
        return map;
    }


}
