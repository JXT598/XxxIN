package com.example.demo.methods;

import com.example.demo.common.CommonConst;
import com.example.demo.common.NumberConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateMethods {
    /**
     * utc时间格式转换
     * @param utcDate
     * @param formatStr
     * @return
     * @throws Exception
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
     * 时间转换公共方法
     * @param vo
     * @param str
     * @param start
     * @param end
     * @param <T>
     * @throws Exception
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

