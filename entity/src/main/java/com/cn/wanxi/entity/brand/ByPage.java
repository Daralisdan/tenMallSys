package com.cn.wanxi.entity.brand;

import lombok.Data;

import java.util.Map;

/**
 * 【分页+条件】
 * 2019/11/24,Create by yaodan
 */
@Data
public class ByPage {
    private Map<String, Object> searchMap;
    private int page;
    private int size;
}
