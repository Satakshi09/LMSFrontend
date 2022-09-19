package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.constant.WebappConstant;
import com.springboot.model.BookDetails;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void addBook(BookDetails bookDetails) {
		this.restTemplate.postForEntity(WebappConstant.LOCALHOST9001BOOK, bookDetails, BookDetails.class);

	}

	@Override
	public void updateBook(BookDetails bookDetails) {
		this.restTemplate.put(WebappConstant.LOCALHOST9001BOOK + "/" + bookDetails.getBookId(), bookDetails,
				BookDetails.class);
	}

	@Override
	public List<BookDetails> listBooks() {
		@SuppressWarnings("unchecked")
		List<BookDetails> bookDetails = (List<BookDetails>) this.restTemplate
				.getForObject(WebappConstant.LOCALHOST9001BOOK, List.class);
		return bookDetails;
	}

	@Override
	public BookDetails getBookById(long bookId) {
		BookDetails bookDetails = this.restTemplate.getForObject(WebappConstant.LOCALHOST9001BOOK + "/" + bookId,
				BookDetails.class);
		return bookDetails;
	}

	@Override
	public void removeBook(long bookId) {
		this.restTemplate.delete(WebappConstant.LOCALHOST9001BOOK + "/" + bookId, BookDetails.class);

	}

	@Override
	public BookDetails getBookByBookCode(long bookCode) {
		BookDetails bookDetails = this.restTemplate.getForObject(WebappConstant.LOCALHOST9001BOOK + "/book/" + bookCode,
				BookDetails.class);
		return bookDetails;
	}

}
