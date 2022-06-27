package com.cathaybk.lambda.BiFunctionTest;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author RogerLo
 * @date 2022/6/27
 */
public class BiFunctionTest {

    public static void main(String[] args) {

        String result = BiFunctionTest.doConvert("Hello", "World",
        (ipt1, ipt2) -> ipt1 + " ~ " + ipt2,
        (String ipt) -> new StringBuilder(ipt).reverse().toString());
        System.err.println("result = " + result);

        System.out.println("====================================================");

        BigDecimal result2 = BiFunctionTest.doConvert("22", 33, (n1, n2) -> {
            return Integer.parseInt(n1) + n2;
        }, (input) -> new BigDecimal(input));
        System.err.println("result2 = " + result2 + ", Type is: " + result2.getClass().getTypeName());

    }

    public static <A1, A2, R1, R2> R2 doConvert(A1 n1, A2 n2,
                                    BiFunction<A1, A2, R1> biFunc,
                                    Function<R1, R2> func) {
        return biFunc.andThen(func).apply(n1, n2);
    }

}
