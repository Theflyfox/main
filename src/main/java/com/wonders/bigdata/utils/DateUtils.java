package com.wonders.bigdata.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/9/6 14:41
 */
public class DateUtils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dateToStr(Date date) {
        return sdf.format(date);
    }
}
