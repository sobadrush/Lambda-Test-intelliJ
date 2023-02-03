package com.cathaybk.lambda.function;

import java.math.BigDecimal;
import java.util.function.Function;

public class Test_Function001 {

    public static void main(String[] args) {
        System.out.println(" === 測試Function進行邏輯抽取 === ");
        System.out.println(" Ans : " +  changeRate(5, (x) -> BigDecimal.valueOf(x * 33)));
    }

    private static BigDecimal changeRate(Integer originAmount, Function<Integer, BigDecimal> func){
        BigDecimal amountScaled = func.apply(originAmount);
        return amountScaled;
    }

}
