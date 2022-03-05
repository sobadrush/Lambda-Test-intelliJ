package com.cathaybk.lambda.booksort;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListSort {

	private static List<Map<String, String>> BOOKLIST = Stream.of(
			Map.of("BookName", "一天學會C#", "Author","Roger", "Publisher", "大宇出版社"),
			Map.of("BookName", "JAVA聖經", "Author","Roger", "Publisher", "基峰出版社"),
			Map.of("BookName", "SQL必會50招", "Author","Jack", "Publisher", "基峰出版社"),
			Map.of("BookName", "如何下好五子棋", "Author","AQ", "Publisher", "五月花出版社"),
			Map.of("BookName", "如何破解梅花陣", "Author","AQ", "Publisher", "七里香出版社"),
			Map.of("BookName", "圖解Github Flow", "Author","Roger", "Publisher", "神腦出版社")
		).collect(Collectors.toList());
	
	public static void main(String[] args) {
//		BookListSort.BOOKLIST.stream().sorted(new Comparator<Map<String, String>>() {
//			@Override
//			public int compare(Map<String, String> map1, Map<String, String> map2) {
//				// System.out.println(map1 + " --- " + map2);
//				return map1.get("Author").charAt(0) - map2.get("Author").charAt(0);
//			}
//		}).forEach(System.out::println);
		
//		BookListSort.BOOKLIST.stream().sorted((map1, map2) -> 
//			map1.get("Author").charAt(0) - map2.get("Author").charAt(0))
//		.forEach(System.out::println);
		
		BookListSort.BOOKLIST.stream().sorted(applyFunc("Author"))
		.forEach(System.out::println);
	}

	private static Comparator<Map<String, String>> applyFunc(String key) {
		return (map1, map2) -> 
			map1.get(key).charAt(0) - map2.get(key).charAt(0);
	}
}
