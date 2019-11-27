package com.cn.wanxi.utils.simpSQL.Helper;

import com.cn.wanxi.utils.simpSQL.config.Config;
import com.cn.wanxi.utils.simpSQL.base.TimerMarker;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author LeesonWong
 * @date 2019/11/17 21:02
 */
public class UtilsHelper {
    private static SimpleDateFormat FORMAT;
    private static SimpleDateFormat FORMATX;
    private static final String DEFAULT_DATE_TIME = "00000000000000";

    static {
        FORMAT = new SimpleDateFormat(Config.getFormatConfigPath("date_time"));
        FORMATX = new SimpleDateFormat(Config.getFormatConfigPath("FORMATX"), java.util.Locale.ENGLISH);
    }

    public static String formatDateTimer(String before) {
        try {
            return FORMAT.format(FORMATX.parse(before));
        } catch (ParseException e) {
            System.err.println(TimerMarker.getTimer() + "请检查输入格式与配置信息");
        }
        return DEFAULT_DATE_TIME;
    }

}
