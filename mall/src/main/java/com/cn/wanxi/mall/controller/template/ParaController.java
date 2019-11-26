package com.cn.wanxi.mall.controller.template;

import com.cn.wanxi.entity.template.ParaEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.template.IParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 数据表： wx_tab_para
 *
 * @Author: SSJ
 * @Date: 11月19日 16:21
 */

@RestController
@RequestMapping("/para")
public class ParaController {
    @Autowired
    private IParaService iParaService;

    /**
     * 【添加参数信息】
     *
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody ParaEntity paraEntity) {
        Msg m;
        int result = iParaService.add(paraEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(paraEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【展示所有参数信息】
     *
     * @return
     */
    @PostMapping("/findAll")
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = iParaService.findAll();
        return list;
    }


    @PostMapping(value = "/findCondPage" , produces = "application/json;charset=UTF-8")
    public Map<String, Object> find(@RequestBody ParaEntity paraEntity, Integer page, Integer size) {
        Map<String, Object> map = iParaService.find(paraEntity, page, size);
        return map;
    }

    /**
     * 【修改参数信息】
     *
     * @param paraEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg update(@RequestBody ParaEntity paraEntity) {
        Msg msg;
        int up = iParaService.update(paraEntity);
        if (up > 0) {
            msg = Msg.success().messageData(paraEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param paraEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg delete(@RequestBody ParaEntity paraEntity) {
        Msg msg;
        int i = iParaService.deleteById(paraEntity);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}
