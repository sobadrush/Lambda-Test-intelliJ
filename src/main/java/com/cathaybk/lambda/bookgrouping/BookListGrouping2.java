package com.cathaybk.lambda.bookgrouping;

import com.cathaybk.model.Book;
import com.cathaybk.model.FakeData;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookListGrouping2 {

    public static void main(String[] args) {
        // System.out.println(FakeData.BookList);
        Map<String, Serializable> gg = FakeData.BookList.parallelStream()
                .collect(Collectors.groupingBy(Book::isOnSale, Collectors.toList()))
                .entrySet()
                .stream().collect(Collectors.toMap(entry -> {
                    if (entry.getKey() == true) {
                        return "特價中";
                    } else {
                        return "原價";
                    }
                }, entry -> {
                    List<Book> blist = entry.getValue();
                    Optional<Book> targetBook;
                    if (entry.getKey() == true) {
                        targetBook = blist.stream().max(BookListGrouping2.priceComparator());
                    } else {
                        targetBook = blist.stream().max(BookListGrouping2.priceComparator().reversed());
                    }
                    return targetBook.get().getPrice();
                }));

        System.out.println("BookListGrouping2.main : " + gg);
    }

    private static Comparator<Book> priceComparator(){
        return (o1, o2) -> {
            BigDecimal priceA = o1.getPrice();
            BigDecimal priceB = o2.getPrice();
            return priceA.subtract(priceB).intValue();
        };
    }
}
