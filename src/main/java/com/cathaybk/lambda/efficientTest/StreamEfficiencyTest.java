package com.cathaybk.lambda.efficientTest;

import java.util.Arrays;

/**
 * @author RogerLo
 * @date 2024/12/29
 */
public class StreamEfficiencyTest {

    // 產生 1000000 個數字
    private static long[] numbers = new long[10000];
    static {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
    }

    public static void main(String[] args){

        // 效能測試範例
        long start = System.currentTimeMillis();
        long sum = Arrays.stream(numbers).parallel().sum();
        long end = System.currentTimeMillis();
        System.out.println(">>> Parallel execution time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        sum = Arrays.stream(numbers).sum();
        end = System.currentTimeMillis();
        System.out.println(">>> Sequential execution time: " + (end - start) + "ms");

    }

}
