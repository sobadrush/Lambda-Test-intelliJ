package com.cathaybk.lambda.bookstore;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookFilterUseFunction {

	public static void main(String[] args) {
//		BookFilterUseFunction.buyBooks(initBooks(), new Function<BookFilterUseFunction.Book, Boolean>() {
//			@Override
//			public Boolean apply(Book bbk) {
//				return bbk.name.startsWith("A");
//			}
//		}).stream().forEach(System.out::println);
		
//		BookFilterUseFunction.buyBooks(initBooks(), (book) -> {
//			return book.name.startsWith("A");
//		}).stream().forEach(System.out::println);
		
		BookFilterUseFunction.buyBooks(initBooks(), myFunc()).stream().forEach(System.out::println);
		
	}


	private static class Book {
		private String name;

		public Book(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + "]";
		}
		
	}

	private static List<Book> initBooks() {
		return Stream.of("A-Book", "B-Book", "C-Book", "D-Book", "E-Book", "Apple-Book")
				.map(Book::new).collect(Collectors.toList());
	}

	private static List<Book> buyBooks(List<Book> allBooks, Function<Book, Boolean> func) {
		return allBooks.stream().filter(bk -> {
			return func.apply(bk);
		}).collect(Collectors.toList());
	}

	private static Function<Book, Boolean> myFunc() {
		return (book) -> {
			return book.name.startsWith("A");
		};
	}
}
