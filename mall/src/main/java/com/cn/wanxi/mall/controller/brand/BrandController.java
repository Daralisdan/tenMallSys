package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.utils.Msg;
import com.cn.wanxi.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;


/**
 * 【品牌管理模块】
 *
 * 数据表： wx_tab_brand	品牌表
 *
 * @author 2019/11/16,Create by yaodan
 */
@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private IBrandService iBrandService;

    /**
     * 【添加品牌信息】
     *
     * @return
     */
    @PostMapping("/add.do")
    public Msg add(BrandEntity brandEntity) {
        Msg m;
        int result = iBrandService.add(brandEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("brand", brandEntity);
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
    @PostMapping("/findAll.do")
    public Msg findAll() {
        Msg msg = null;
        List<Map<String, Object>> list = iBrandService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("brand", list);
        }
        return msg;
    }

    /**
     * 【根据品牌id查询信息】
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/findById.do")
    public Msg findById(int id) {
        Msg msg = null;
        BrandEntity byId = iBrandService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("brand", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【修改品牌信息】
     *
     * @param brandEntity
     * @return
     */
    @PostMapping("/update.do ")
    public Msg updateInfo(BrandEntity brandEntity) {
        Msg msg = null;
        int up = iBrandService.update(brandEntity);
        if (up > 0) {
            msg = Msg.success().messageData("brand", brandEntity);
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
    @PostMapping("/delete.do")
    public Msg deleteById(int id) {
        Msg msg = null;
        int i = iBrandService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

}
