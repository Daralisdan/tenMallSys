package com.cn.wanxi.entity.brand;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页对象
 * <p>
 * 2019/11/19,Create by yaodan
 */
@Data
public class PageList  {
    //当前页
    private int page;
    //每页记录数
    private int total;
    //总页数
    private int pages;
    //总记录数
    private int totalRows;

    private List list = new ArrayList();
}
