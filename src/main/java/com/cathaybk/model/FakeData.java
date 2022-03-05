package com.cathaybk.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FakeData {

	public static List<Book> BookList = Stream.of(
			new Book("一天學會C#", "Roger", BigDecimal.valueOf(200), "大宇出版社", false, 235),
			new Book("JAVA聖經", "Roger", BigDecimal.valueOf(345), "基峰出版社", false, 720),
			new Book("SQL必會50招", "Jack", BigDecimal.valueOf(630), "基峰出版社", true, 534),
			new Book("如何下好五子棋", "Jack", BigDecimal.valueOf(169), "五月花出版社", true, 173),
			new Book("如何破解梅花陣", "AQ", BigDecimal.valueOf(182), "七里香出版社", false, 220),
			new Book("圖解Github Flow", "Roger", BigDecimal.valueOf(430), "神腦出版社", true, 333)
	).collect(Collectors.toList());
	
	// ref. https://github.com/nurgasemetey/json-to-java
	public static Map <String, Object> originDataMap = new HashMap < String, Object > () {
	    {
	        put("Companies", new ArrayList<Map < String, Object >>() {
	            {
	                add(new HashMap < String, Object > () {
	                    {
	                        put("NAME", "CTBC");
	                        put("RATE_A", "3.14");
	                        put("RATE_B", "2.3");
	                        put("FREE_WITHDRAW", "5");
	                        put("Emps", new ArrayList() {
	                            {
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Roger");
	                                        put("age", "30");
	                                    }
	                                });
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Amy");
	                                        put("age", "22");
	                                    }
	                                });
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Kevin");
	                                        put("age", "26");
	                                    }
	                                });
	                            }
	                        });
	                    }
	                });
	                add(new HashMap < String, Object > () {
	                    {
	                        put("NAME", "CATHAY");
	                        put("RATE_A", "6.66");
	                        put("RATE_B", "5.2");
	                        put("FREE_WITHDRAW", "15");
	                        put("Emps", new ArrayList<Map < String, String >>() {
	                            {
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Tony");
	                                        put("age", "43");
	                                    }
	                                });
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Ray");
	                                        put("age", "29");
	                                    }
	                                });
	                                add(new HashMap < String, String > () {
	                                    {
	                                        put("name", "Stella");
	                                        put("age", "12");
	                                    }
	                                });
	                            }
	                        });
	                    }
	                });
	            }
	        });
	    }
	};
}
