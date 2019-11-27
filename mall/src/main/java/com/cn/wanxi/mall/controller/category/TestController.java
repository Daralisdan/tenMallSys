package com.cn.wanxi.mall.controller.category;

import com.cn.wanxi.entity.category.TestEntity;
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
}
