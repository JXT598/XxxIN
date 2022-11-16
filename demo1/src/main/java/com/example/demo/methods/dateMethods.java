package com.example.demo.methods;

import com.example.demo.common.CommonConst;
import com.example.demo.common.NumberConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateMethods {
    /**
     * utc时间格式转换
     */
    public static String utcDateFormat(String utcDate, String formatStr) throws Exception {
        if (StringUtils.isBlank(utcDate)) {
            return utcDate;
        }
        String dateFromUtc = utcDate.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date1 = format.parse(dateFromUtc);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        return simpleDateFormat.format(date1);
    }

    /**
     * 本地时间格式转utc格式
     */
    public static String formatUTC(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat utcSdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Calendar cal = Calendar.getInstance();
        // 取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        try {
            Date dateValue = sdf.parse(date);
            long longDate = dateValue.getTime();
            longDate = longDate - zoneOffset - dstOffset;
            Date UTCDate = new Date(longDate);
            return utcSdf.format(UTCDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * utc格式转本地时间格式
     */
    public static String parseUTC(String utcDate) {
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        utcDate = utcDate.replace("Z", " UTC"); //注意UTC前有空格
        try {
            Date date = utcFormat.parse(utcDate);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 时间转换公共方法
     */
    public static <T> void date(T vo, String str, String start, String end) throws Exception {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(vo);
        String string = (String) wrapper.getPropertyValue(str);
        if (StringUtils.isBlank(string) || string.length() <= 1){
            return;
        }
        string = string.substring(1,string.length() - 1).replaceAll(CommonConst.SEPARATOR_ESCAPE_DOUBLE_QUOTES, "");
        String[] dates = string.split(CommonConst.SEPARATOR_COMMA);
        if (dates.length != NumberConst.NUMBER_TWO){
            return;
        }
        wrapper.setPropertyValue(start, utcDateFormat(dates[0], CommonConst.FORMAT_DATE_STR));
        wrapper.setPropertyValue(end,utcDateFormat(dates[1], CommonConst.FORMAT_DATE_STR));
    }
}

