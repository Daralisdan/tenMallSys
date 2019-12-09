package com.cn.wanxi.entity.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页对象
 * <p>
 * 2019/11/19,Create by zhoushiling
 */
public class PageList {
    //当前页
    private int page;
    //总行数
    private int totalRows;
    //总页数
    private int pages;
    private int total;



    private List list = new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getList() {
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}