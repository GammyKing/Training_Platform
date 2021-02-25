package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xhz
 * @description 创建时间格式工具
 * @date 2021-01-20
 */
public class DateFormatUtil {
    public static SimpleDateFormat dateFormat;

    public static String  date2String(Date paramDate){
        return getDateFormat().format(paramDate);
    }

    //单例模式
    public static SimpleDateFormat getDateFormat(){
        if(dateFormat==null){
            dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return dateFormat;
    }
}
