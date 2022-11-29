package com.cathaybk.model;

/**
 * 測試 Java 16 新特性： record 類別
 * ref. https://juejin.cn/post/7096810735417688078
 */
public class TestRecordInMethod {

    public static int calTriangleLength(int edge1, int edge2, int edge3) {

        // 在 function 中使用 record
        record Triangle(int aa, int bb, int cc) {
        }

        Triangle triangle = new Triangle(edge1, edge2, edge3);
        return triangle.aa + triangle.bb + triangle.cc;
    }

    public static void main(String[] args) {
        System.out.println("三角形周長：" + TestRecordInMethod.calTriangleLength(11, 22, 33));
    }

}
