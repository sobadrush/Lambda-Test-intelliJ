package com.cathaybk.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaConsumerTest {

	@SuppressWarnings("unused")
	private static <T> void myForeach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}

	private static <T, R> List<R> myMap(List<T> list, Function<T, R> func) {
		List<R> rList = new ArrayList<>();
		for (T t : list) {
			rList.add(func.apply(t));
		}
		return rList;
	}

	public static void main(String[] args) {
//		List<String> list = Arrays.asList("A", "B", "C", "D");
//		myForeach(list, (str) -> {
//			System.out.println("str = " + str);
//		});

//		List<Integer> list = Arrays.asList(11, 22, 33, 44, 55);
//		myMap(list, new Function<Integer, String>() {
//			@Override
//			public String apply(Integer nn) {
//				return "® " + nn;
//			}
//		}).stream().forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(11, 22, 33, 44, 55);
		myMap(list, oriInput -> oriInput + "---GGG").stream().forEach(System.out::println);
	}
}
