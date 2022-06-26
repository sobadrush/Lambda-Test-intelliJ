package com.cathaybk.lambda.ConsumerTest;

import java.util.function.Consumer;

/**
 * @author RogerLo
 * @date 2022/6/26
 */
public class ConsumerTest001 {

    public static void main(String[] args) {
        // Advance → Consumer throw Exception
        String actString = "CaseA";
        ConsumerTest001.testConsumerThrow(e -> {
            if (actString.equals("CaseA")) {
                throw new ArithmeticException("CaseA - CaseA - CaseA");
            }
            if (actString.equals("CaseB")) {
                throw new NullPointerException("CaseB - CaseB - CaseB");
            }
        });
    }

    public static void testConsumerThrow(Consumer<RuntimeException> exceptionConsumer) {
        exceptionConsumer.accept(null);
    }

}
