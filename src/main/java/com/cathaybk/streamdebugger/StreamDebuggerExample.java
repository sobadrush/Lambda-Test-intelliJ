package com.cathaybk.streamdebugger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author RogerLo
 * @date 2022/5/8
 */
public class StreamDebuggerExample {

    // 計算value的因數
    public static IntStream factorize(int value) {
        List<Integer> facList = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            while (value % i == 0) {
                facList.add(value);
                facList.add(i);
                value /= i;
            }
        }
        return facList.stream().mapToInt(val -> Integer.valueOf(val));
    }

    public static void main(String[] args) {
        int[] results = IntStream.of(10, 87, 97, 43, 121, 20)
                .flatMap(StreamDebuggerExample::factorize)
                .distinct()
                .sorted()
                .toArray();
        System.out.println("results = " + Arrays.toString(results));
    }

}
