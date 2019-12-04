package com.cn.wanxi.mall.controller.category;

import com.cn.wanxi.dao.category.IBrandToCategoryDao;
import com.cn.wanxi.entity.category.TestEntity;
import com.cn.wanxi.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author LeesonWong
 * @date 2019/11/26 23:17
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    IBrandService service_01;

    @Autowired
    IBrandService service_02;

    @Autowired
    IBrandService service_03;

    @Autowired
    IBrandService service_04;

    @Autowired
    IBrandToCategoryDao dao_01;

    @Autowired
    IBrandToCategoryDao dao_02;

    @Autowired
    IBrandToCategoryDao dao_03;

    @Autowired
    IBrandToCategoryDao dao_04;


    @PostMapping(value = "/test_01",produces = "application/json;charset=UTF-8")
    public String test_01(String name){
        char[] arr = new char[name.length()];
        for(int i = 0;i < name.length();++i){
            arr[i] = name.charAt(name.length()-1-i);
        }
        String result = new String(arr);
        return result;
    }

    @PostMapping(value = "/test_02",produces = "application/json;charset=UTF-8")
    public String test_02(@RequestBody TestEntity name){
        int id = name.getId();
        String x = name.getName();
        Date date = name.getUpdateTimer();
        System.out.println(name);

        return "all";
    }

    /**
     * 测试Spring自动装填的对象是单例还是多例
     * @return
     */
    @PostMapping(value = "/test_03",produces = "application/json;charset=UTF-8")
    public String test_03(){
        System.out.println(service_01);
        System.out.println(service_01);
        System.out.println(service_01);


        System.out.println(service_01);
        System.out.println(service_01);
        System.out.println(service_01);

        return "test_03测试结束";
    }

}
