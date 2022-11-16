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
    }
}
