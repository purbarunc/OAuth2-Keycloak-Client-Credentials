package com.codex.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codex.bookapi.domain.Book;
import com.codex.bookapi.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public Book getBookById(@RequestParam int id) {
		return bookService.getBookById(id);
	}
}
