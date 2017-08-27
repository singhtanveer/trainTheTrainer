package com.tanveer.association.withXML.manyToMany;

import java.util.HashSet;
import java.util.Set;

public class Book {
	
	Integer bookId;
	String bookName;
	Set<Author> authors = new HashSet<Author>();
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
}
