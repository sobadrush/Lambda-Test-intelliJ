package com.cathaybk.util.functionTest;

import java.util.function.Function;

/**
 */
public class UtilFunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> ff1 = (xx) -> xx * 2;
        Function<Integer, Integer> ff2 = (xx) -> xx * xx;

        System.out.println("====================================================");
        int ans1 = ff1.andThen(ff2).apply(3); // 3 * 2 = 6; 6 * 6 = 36
        System.out.println("ans1 = " + ans1);
        System.out.println("====================================================");
        Integer ans2 = ff1.compose(ff2).apply(3); // 3 x 2 = 6; 6 * 3 = 18
        System.out.println("ans2 = " + ans2);
    }
}
