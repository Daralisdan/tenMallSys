package com.cn.wanxi.entity;

import java.util.LinkedHashMap;

/**
 * @author LeesonWong
 * @date 2019/11/26 15:07
 */
public class PageSelect {
    private LinkedHashMap<String,String> entityMap;
    private int page;
    private int size;

    public PageSelect() {
    }

    public PageSelect(LinkedHashMap<String, String> entityMap, int page, int size) {
        this.entityMap = entityMap;
        this.page = page;
        this.size = size;
    }

    public LinkedHashMap<String, String> getEntityMap() {
        return entityMap;
    }

    public void setEntityMap(LinkedHashMap<String, String> entityMap) {
        this.entityMap = entityMap;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageSelect{" +
                "entityMap=" + entityMap +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
