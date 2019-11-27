package com.cn.wanxi.utils.simpSQL.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 抽取该类作为底层的一部分而不是放在一些获取数据或特定结构体的模块中
 *
 * @author LeesonWong
 * @date 2019/11/17 17:18
 */
public class TimerMarker {
    private static Date date;
    private static SimpleDateFormat dateFormat;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        TimeZone.setDefault(timeZone);
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public static String getTimer() {
        return dateFormat.format(date) + "\t";
    }
}
