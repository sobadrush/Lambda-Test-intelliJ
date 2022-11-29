package com.cathaybk.model;

/**
 * 測試 Java 16 新特性： record 類別
 * ref. https://juejin.cn/post/7096810735417688078
 */
public class Product {

    // 類別內部 使用 record
    private record Detail(String txnNo, String storeLoc) {
    }

    public static void main(String[] args) {
        Product.Detail detail = new Product.Detail("TXN005566", "711永和店");
        System.err.println("detail = " + detail);
    }

}
