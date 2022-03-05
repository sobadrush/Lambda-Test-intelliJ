package com.cathaybk.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String author;
	private BigDecimal price;
	private String publisher;
	private boolean isOnSale;
	private int pages;

	public Book() {
		super();
	}
	
	public Book(String name, String author, BigDecimal price, String publisher, boolean isOnSale, int pages) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.isOnSale = isOnSale;
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public boolean isOnSale() {
		return isOnSale;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
}
