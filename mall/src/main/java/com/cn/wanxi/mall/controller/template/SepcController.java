package com.cn.wanxi.mall.controller.template;


import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.entity.utils.Msg;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * wx_tab_sepc （参数表）
 *
 * @Author: SSJ
 * @Date: 11月19日 16:21
 */

@RestController
@RequestMapping("/sepc")
public class SepcController {

    @Autowired
    private ISepcService iSepcService;

    /**
     * 【添加规格信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(SepcEntity sepcEntity) {
        Msg msg;
        int result = iSepcService.add(sepcEntity);
        if (!isEmpty(result)) {
            msg = Msg.success().messageData("sepc", sepcEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【展示所有规格信息】
     *
     * @return
     */
    @PostMapping("/findAll")
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = iSepcService.findAll();
        return list;
    }


    @PostMapping("/find")
    public Map<String, Object> find(SepcEntity sepcEntity, Integer page, Integer size) {
        Map<String, Object> map = iSepcService.find(sepcEntity, page, size);
        return map;
    }

    /**
     * 【修改规格信息】
     *
     * @param sepcEntity
     * @return
     */
    @PostMapping("/update")
    public Msg update(SepcEntity sepcEntity) {
        Msg msg;
        int up = iSepcService.update(sepcEntity);
        if (up > 0) {
            msg = Msg.success().messageData("sepc", sepcEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Msg delete(int id) {
        Msg msg;
        int i = iSepcService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

}
