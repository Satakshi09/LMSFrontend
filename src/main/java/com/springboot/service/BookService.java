package com.springboot.service;

import java.util.List;

import com.springboot.model.BookDetails;

public interface BookService {

	public void addBook(BookDetails bookDetails);

	public void updateBook(BookDetails bookDetails);

	public List<BookDetails> listBooks();

	public BookDetails getBookById(long bookId);

	public BookDetails getBookByBookCode(long bookCode);

	public void removeBook(long bookId);

}
