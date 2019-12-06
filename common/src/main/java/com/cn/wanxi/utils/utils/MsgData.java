package com.cn.wanxi.utils.utils;

import lombok.Data;

import java.util.List;

/**
 * @Author Create by yaodan,2019/12/5
 */
@Data
public class MsgData<T> {
    private List<T> rows;
    private int total;

    public MsgData(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }
}
