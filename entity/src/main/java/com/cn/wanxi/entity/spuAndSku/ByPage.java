package com.cn.wanxi.entity.spuAndSku;

import java.util.Map;

public class ByPage {
    private Map<String, Object> searchMap;
    private int page;
    private int size;

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
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
        return "ByPage{" +
                "searchMap=" + searchMap +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
