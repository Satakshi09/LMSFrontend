package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.constant.WebappConstant;
import com.springboot.model.AuthorDetails;
import com.springboot.model.BookDetails;
import com.springboot.service.AuthorService;
import com.springboot.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/bookList")
	public String showBookListPage(Model model, HttpSession session) {

		List<BookDetails> bookDetails = this.bookService.listBooks();
		model.addAttribute(WebappConstant.BOOKS, bookDetails);
		return WebappConstant.BOOKLIST;
	}

	@RequestMapping("/addform")
	public String showAddForm(Model model, HttpSession session) {

		List<AuthorDetails> authorDetails = this.authorService.listAuthors();
		model.addAttribute(WebappConstant.AUTHORS, authorDetails);
		return WebappConstant.ADDBOOKFORM;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("book") BookDetails bookDetails, Model model) {
		BookDetails existingBook = this.bookService.getBookByBookCode(bookDetails.getBookCode());

		if (existingBook != null) {
			model.addAttribute(WebappConstant.MESSAGE, WebappConstant.BOOKCODESHOULDBEUNIQUE);
			List<AuthorDetails> authorDetails = this.authorService.listAuthors();
			model.addAttribute(WebappConstant.EXISTINGBOOK, bookDetails);
			model.addAttribute(WebappConstant.AUTHORS, authorDetails);
			return WebappConstant.ADDBOOKFORM;
		}
		this.bookService.addBook(bookDetails);
		return WebappConstant.REDIRECTBOOKLIST;

	}

	@RequestMapping("/editform")
	public String showEditForm(Model model, HttpSession session) {

		List<AuthorDetails> authorDetails = this.authorService.listAuthors();
		model.addAttribute(WebappConstant.AUTHORS, authorDetails);
		return WebappConstant.EDITBOOKFORM;
	}

	@RequestMapping("/edit/{id}")
	public String handleEditForm(@PathVariable("id") long bookId, HttpSession session) {
		BookDetails bookDetails = this.bookService.getBookById(bookId);
		session.setAttribute(WebappConstant.BOOK, bookDetails);
		return WebappConstant.REDIRECTEDITFORM;
	}

	@RequestMapping("/delete/{id}")
	public String handleDelete(@PathVariable("id") long bookId) {
		this.bookService.removeBook(bookId);
		return WebappConstant.REDIRECTBOOKLIST;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") BookDetails bookDetails) {
		this.bookService.updateBook(bookDetails);
		return WebappConstant.REDIRECTBOOKLIST;
	}
}
