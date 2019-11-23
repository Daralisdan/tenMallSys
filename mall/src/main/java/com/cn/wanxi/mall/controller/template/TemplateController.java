package com.cn.wanxi.mall.controller.template;

import com.cn.wanxi.entity.template.TemplateEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.template.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 【模板管理】
 * 数据表： wx_tab_template （模板表）
 * 2019/11/18,Create by ssj
 */

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private ITemplateService iTemplateService;

    /**
     * 【添加品牌信息】
     *
     * @return
     */
    @PostMapping("/add")
    public Msg add(TemplateEntity templateEntity) {
        Msg m;
        int result = iTemplateService.add(templateEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("templateEntity", templateEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 【展示所有品牌信息】
     *
     * @return
     */
    @PostMapping("/findAll")
    public List<Map<String, Object>> findAll(HttpServletResponse response, HttpServletRequest request) {

        List<Map<String, Object>> list = iTemplateService.findAll();
        return list;
    }


    @PostMapping("/find")
    public Map<String, Object> find(TemplateEntity templateEntity, Integer page, Integer size) {
        Map<String, Object> map = iTemplateService.find(templateEntity, page, size);
        return map;
    }

    /**
     * 【修改品牌信息】
     *
     * @param templateEntity
     * @return
     */
    @PostMapping("/update")
    public Msg update(TemplateEntity templateEntity) {
        Msg msg;
        int up = iTemplateService.update(templateEntity);
        if (up > 0) {
            msg = Msg.success().messageData("templateEntity", templateEntity);
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
        int i = iTemplateService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}
