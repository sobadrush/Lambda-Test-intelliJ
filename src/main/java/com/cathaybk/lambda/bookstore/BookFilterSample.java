package com.cathaybk.lambda.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface BookPredicate {
	boolean test(Map<String, String> bookMap);
}

public class BookFilterSample {
	
	public static void main(String[] args) {
		List<Map<String, String>> bookList = Stream.of(
			Map.of("BookName", "一天學會C#", "Author","Roger", "Publisher", "大宇出版社"),
			Map.of("BookName", "JAVA聖經", "Author","Roger", "Publisher", "基峰出版社"),
			Map.of("BookName", "SQL必會50招", "Author","Jack", "Publisher", "基峰出版社"),
			Map.of("BookName", "如何下好五子棋", "Author","AQ", "Publisher", "五月花出版社"),
			Map.of("BookName", "如何破解梅花陣", "Author","AQ", "Publisher", "七里香出版社"),
			Map.of("BookName", "圖解Github Flow", "Author","Roger", "Publisher", "神腦出版社")
		).collect(Collectors.toList());
		
//		bookList = filter(bookList, new BookPredicate() {
//			@Override
//			public boolean test(Map<String, String> bookMap) {
//				return "基峰出版社".equals(bookMap.get("Publisher"));
//			}
//		});
		
		bookList = filter(bookList, (bookMap) -> "基峰出版社".equals(bookMap.get("Publisher")));
		
		bookList.parallelStream().forEach(System.out::println);
	}
	
	static List<Map<String, String>> filter(List<Map<String, String>> bookList, BookPredicate predicate) {
		List<Map<String, String>> rtnList = new ArrayList<Map<String, String>>();
		for (Map<String, String> hmap : bookList) {
			if (predicate.test(hmap)) {
				rtnList.add(hmap);
			}
		}
		return rtnList;
	}
}
