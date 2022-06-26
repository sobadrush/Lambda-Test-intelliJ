package com.cathaybk.lambda.BiConsumerTest;

import java.util.function.BiConsumer;

/**
 * @author RogerLo
 * @date 2022/6/26
 */
public class BiConsumerTest001 {

    public static void main(String[] args) {

        // Basic
        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println("addTwo is : " + (x + y));
        addTwo.accept(111, 222);

        // Advance → High order function
        BiConsumerTest001.handleTwoParam("Hello", "World!", (s1, s2) -> {
            System.err.println("s1 concat s2 = " + s1 + " " + s2);
        });

    }

    public static <T> void handleTwoParam(T input1, T input2, BiConsumer<T, T> biConsumer) {
        biConsumer.accept(input1, input2);
    }

}
