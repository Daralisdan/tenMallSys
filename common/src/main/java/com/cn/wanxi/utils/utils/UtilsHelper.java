package com.cn.wanxi.utils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LeesonWong
 * @date 2019/11/17 21:02
 */
public class UtilsHelper {
    private static SimpleDateFormat FORMAT;
    private static SimpleDateFormat FORMATX;
    private static final String DEFAULT_DATE_TIME = "00000000000000";

    static {
//        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
//        TimeZone.setDefault(timeZone);
        FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
        FORMATX = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
    }

    public static String formatDateTimer(String before) {
        try {
            return FORMAT.format(FORMATX.parse(before));
        } catch (ParseException e) {
            System.err.println("请检查输入格式与配置信息");
        }
        return DEFAULT_DATE_TIME;
    }

    public static String formatDateTimer(Date date){
        return FORMAT.format(date);
    }

}
