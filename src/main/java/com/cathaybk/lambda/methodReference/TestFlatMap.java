package com.cathaybk.lambda.methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFlatMap {

	public static void main(String[] args) {
		List<String> lyrics = Arrays.asList("三,民,主義", "吾黨,所忠", "以建民,國", "以,進大,同");
		lyrics.stream().forEach(System.out::println);
		
		System.out.println("-------------------------------------");
		
		StringBuilder sb = new StringBuilder();
		lyrics.stream().map(ss -> ss.split(",")).collect(Collectors.toList()).stream()
				.map(Arrays::stream)
				.forEach(stm -> {
					stm.forEach(sb::append);
				});
		System.out.println(sb.toString());
		
		System.out.println("-------------------------------------");
		
		sb.setLength(0); // clear
		lyrics.stream().map(ss -> ss.split(","))
				.flatMap(Arrays::stream)
				.forEach(sb::append);
		System.out.println(sb.toString());
		
		System.out.println("-------------------------------------");
		
		List<String> rList = new ArrayList<>();
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream.of(array).forEach(strArr -> {
			for (String ss : strArr) {
				if (ss.equals("a")) {
					continue;
				}
				rList.add(ss);
			}
		});
		rList.forEach(System.out::println);
		
		System.out.println("-------------------------------------");
		array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Arrays.stream(array).flatMap(xx -> {
			System.out.println("xx = " + xx);
			return Stream.of(xx).filter(ss -> !ss.equals("a"));
		}).collect(Collectors.toList()).forEach(System.out::println);

	}

}
