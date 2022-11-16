package com.example.demo;

import com.example.demo.vo.letterVO;
import com.example.demo.methods.dateMethods;

public class test {
    public static void main(String[] args) throws Exception {
        letterVO letterVO = new letterVO();
        letterVO.setDateStr("[\"2021-11-16T16:00:00.000Z\",\"2022-12-14T16:00:00.000Z\"]");
        dateMethods.date(letterVO, "dateStr", "dateStart", "dateEnd");
        System.out.println(letterVO.getDateStart());
        System.out.println(letterVO.getDateEnd());

        String dateTest = "2018-09-28T16:00:00.000Z";
        String dateTest1 = dateMethods.parseUTC(dateTest);
        String dateTest2 = dateMethods.formatUTC(dateTest1);
        System.out.println(dateTest1);
        System.out.println(dateTest2);
    }
}
