package com.tanveer.association.withXML.manyToMany;

import java.util.HashSet;
import java.util.Set;

public class Author {
	
	Integer authorId;
	String authorName;
	Set<Book> books = new HashSet<Book>();
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
