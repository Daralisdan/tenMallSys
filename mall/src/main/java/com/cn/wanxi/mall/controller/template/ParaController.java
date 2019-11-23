package com.cn.wanxi.mall.controller.template;

import com.cn.wanxi.entity.template.ParaEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.template.IParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/add")
    public Msg add(ParaEntity paraEntity) {
        Msg m;
        int result = iParaService.add(paraEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("para", paraEntity);
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


    @PostMapping("/find")
    public Map<String, Object> find(ParaEntity paraEntity, Integer page, Integer size) {
        Map<String, Object> map = iParaService.find(paraEntity, page, size);
        return map;
    }

    /**
     * 【修改参数信息】
     *
     * @param paraEntity
     * @return
     */
    @PostMapping("/update ")
    public Msg update(ParaEntity paraEntity) {
        Msg msg;
        int up = iParaService.update(paraEntity);
        if (up > 0) {
            msg = Msg.success().messageData("para", paraEntity);
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
        int i = iParaService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}
