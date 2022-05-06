package com.cathaybk.lambda.optional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RogerLo
 * @date 2022/5/6
 */
public class OptionalTest002 {

    public static void main(String[] args) {

        Map<String, List<String>> myDataMap = new HashMap<>();
        myDataMap.put("data1", Stream.of("apple", "book", "cat").collect(Collectors.toList()));
        myDataMap.put("data2", null);

        // System.out.println(myDataMap.get("data1"));
        // System.out.println(myDataMap.get("data2"));

        System.out.println("OptionalTest002.main");

        System.out.println(Optional.ofNullable(myDataMap.get("data2"))
                .orElseThrow(() -> new RuntimeException("FUCK")));
    }

}
