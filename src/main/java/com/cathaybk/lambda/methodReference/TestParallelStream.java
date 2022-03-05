package com.cathaybk.lambda.methodReference;

import java.util.Arrays;
import java.util.List;

public class TestParallelStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
		list.parallelStream().forEach(x -> System.out.print(x + " ,"));
		System.out.println("----------");
		list.parallelStream().forEachOrdered(x -> System.out.print(x + " ,"));
	}

}
