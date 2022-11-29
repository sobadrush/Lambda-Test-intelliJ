package com.cathaybk.model;

import java.text.ParseException;
import java.util.Date;


/**
 * 測試 Java 16 新特性： record 類別
 * ref. https://juejin.cn/post/7096810735417688078
 */
public record MyRecordEmpData(String empNo, String empName, Integer salary, java.util.Date birthday) {
    public static void main(String[] args) throws ParseException {
        // ---
        MyRecordEmpData empRdData1 = new MyRecordEmpData("00589739", "Roger Lo", 35000, new Date());
        MyRecordEmpData empRdData2 = new MyRecordEmpData("00589739", "Roger Lo", 35000, new Date());
        System.err.println(empRdData1.equals(empRdData2)); // true
    }
}
