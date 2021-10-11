package com.kalyb.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kalyb.mvc.models.Book;
import com.kalyb.mvc.services.BookService;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value="/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.getOne(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping(value="/books")
	public String showAll(Model model) {
		List<Book> allBooks = bookService.getAll();
		model.addAttribute("allBooks", allBooks);
		return "books.jsp";
	}
}
