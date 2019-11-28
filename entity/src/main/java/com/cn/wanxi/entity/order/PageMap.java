package com.cn.wanxi.entity.order;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装分页对象
 * <p>
 * 2019/11/19
 */
@Data
public class PageMap {
    //当前页
    private int page;
    //每页记录数
    private int total;
    //总页数
    private int pages;
    //总记录数
    private int totalRows;

    private Map<String, Object> map = new LinkedHashMap<>();

}
