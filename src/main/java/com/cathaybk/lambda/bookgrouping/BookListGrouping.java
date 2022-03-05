package com.cathaybk.lambda.bookgrouping;

import java.util.stream.Collectors;

import com.cathaybk.model.FakeData;

public class BookListGrouping {

	public static void main(String[] args) {
//		FakeData.BookList.forEach(System.out::println);
		System.out.println("-------------------------------");
		
//		FakeData.BookList.stream()
////			.collect(Collectors.groupingBy(Book::getAuthor))
//			.collect(Collectors.groupingBy(x -> x.getPublisher()))
//			.entrySet()
//			.stream()
//			.peek(entry -> entry.getValue().stream().peek(bk -> {
//				bk.setAuthor("@" + bk.getAuthor() + "@");
//			}).collect(Collectors.toList()))
//			.forEach(xx -> System.out.println(xx.getKey() + " - " + xx.getValue()));
		
//		FakeData.BookList.stream()
//			.collect(Collectors.groupingBy((book) -> {
//				return book.isOnSale();
//			})
//		).entrySet().stream().collect(Collectors.toMap(entry -> {
//			if (entry.getKey() == true) {
//				return "特價中";
//			} else {
//				return "無特價";
//			}
//		}, Map.Entry::getValue))
//		.forEach((x, y) -> { // accept(String x, List<Book> y)
//			System.out.println(x + " - " + y);
//		});
		
		FakeData.BookList.stream()
		.collect(Collectors.groupingBy((book) -> {
			return book.isOnSale();
		})
		).entrySet().stream().collect(Collectors.toMap(entry -> {
			return entry.getKey() == true ? "特價中": "無特價";
		}, entry -> entry.getValue()))
		.forEach((x, y) -> { // accept(String x, List<Book> y)
			System.out.println(x + " - " + y);
		});
		
	}

}
