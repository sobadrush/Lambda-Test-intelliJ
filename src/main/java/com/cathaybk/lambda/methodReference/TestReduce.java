package com.cathaybk.lambda.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

class RogerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
}

public class TestReduce {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

//		String longestWord = wordList.get(0);
//		for (int i = 1; i < wordList.size(); i++) {
//			if (longestWord.length() < wordList.get(i).length()) {
//				longestWord = wordList.get(i);
//			}
//		}
//		System.out.println(longestWord);

		String longestWord = wordList.parallelStream()
				.reduce((String w1, String w2) -> w1.length() < w2.length() ? w2 : w1).get();
		System.out.println("longestWord = " + longestWord);

		System.out.println("================================");

		int[] ages = new int[] { 11, 23, 6, 81, 43, 32 };
		Arrays.stream(ages).boxed().reduce(new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer prev, Integer next) {
				return prev + next;
			}
		}).ifPresent(ans -> System.out.println("result is : " + ans));
		
		System.out.println("================================");
		
		Predicate<Integer> p1 = (x) -> x > 30;
		Predicate<Integer> p2 = (x) -> x < 44;
		Arrays.stream(ages).boxed().filter(p1.and(p2)).forEach(System.out::println);
				
	}

}
