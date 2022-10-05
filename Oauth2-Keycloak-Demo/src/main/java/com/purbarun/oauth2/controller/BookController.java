package com.purbarun.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.purbarun.oauth2.domain.Book;
import com.purbarun.oauth2.service.BookRestTemplateService;
import com.purbarun.oauth2.service.BookWebClientService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRestTemplateService bookRestTemplateService;
	@Autowired
	private BookWebClientService bookWebClientService;

	@GetMapping("/restTemplate")
	@ResponseStatus(HttpStatus.OK)
	public Book getBookRestTemplate(@RequestParam int id) {
		return bookRestTemplateService.getBook(id);
	}

	@GetMapping("/webClient")
	@ResponseStatus(HttpStatus.OK)
	public Book getBookWebClient(@RequestParam int id) {
		return bookWebClientService.getBook(id);
	}
}
