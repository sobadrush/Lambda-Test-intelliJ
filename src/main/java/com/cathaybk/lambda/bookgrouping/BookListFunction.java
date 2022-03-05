package com.cathaybk.lambda.bookgrouping;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cathaybk.model.Book;
import com.cathaybk.model.FakeData;

public class BookListFunction {

	public static void main(String[] args) {
		System.out.println(printBooknameAndAuthor(FakeData.BookList, handlerBookNameAndAuthor()));
	}

	private static Function<List<Book>, String> handlerBookNameAndAuthor() {
		StringBuilder sb = new StringBuilder();
		return bList -> {
			bList.forEach(bb -> {
				sb.append(bb.getName()).append(" - ").append(bb.getAuthor()).append("\n");
			});
			return sb.toString();
		};
	}
	
	private static String printBooknameAndAuthor(List<Book> books, Function<List<Book>, String> func) {
		String bookNameAuthor = func.apply(books);
		return Stream.of(bookNameAuthor.split("\n"))
				.map(x -> "@@@" + x + "@@@")
				.collect(Collectors.joining("\n"));
	}
	
}
