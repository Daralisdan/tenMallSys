package com.cn.wanxi.mall.controller.template;


import com.cn.wanxi.entity.template.SepcEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.template.ISepcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
     * 添加规格选项
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Map<String, String> add(@RequestBody Map<String, Object> map) {
        String name = map.get("name").toString();
        String options = map.get("options").toString();
        int seq = Integer.parseInt(map.get("seq").toString());
        int templateId = Integer.parseInt(map.get("template_id").toString());
        Map<String, String> resultMap = new TreeMap<>();
        if (iSepcService.isNameExist(name) && iSepcService.add(name, options, seq, templateId)) {//添加失败
            resultMap.put("code", "0");
            resultMap.put("message", " 新增成功");
            return resultMap;
        } else {//添加成功
            resultMap.put("code", "1");
            resultMap.put("message", " 新增失败");
            return resultMap;
        }

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


    @PostMapping(value = "/findCondPage", produces = "application/json;charset=UTF-8")
    public Map<String, Object> find(@RequestBody SepcEntity sepcEntity) {
        Map<String, Object> map = iSepcService.findCondPage(sepcEntity);
        return map;
    }

    /**
     * 【修改规格信息】
     *
     * @param sepcEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Map<String, Object> update(@RequestBody SepcEntity sepcEntity) {
        Msg msg;
        int up = iSepcService.update(sepcEntity);
        if (up > 0) {
            msg = Msg.success().messageData(sepcEntity);
        } else {
            msg = Msg.fail();
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("code", msg.getCode());
        map.put("message", msg.getMsg());
        return map;
    }

    /**
     * 【根据id删除】
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Map<String, Object> delete(@RequestBody Map<String, Object> map) {
        Map<String, Object> resultMap = new TreeMap<>();
        if (iSepcService.deleteById(Integer.valueOf(map.get("id").toString()))) {
            resultMap.put("code", "0");
            resultMap.put("message", " 删除成功");
        } else {
            resultMap.put("code", "1");
            resultMap.put("message", " 删除失败");
        }
        return resultMap;
    }

}
