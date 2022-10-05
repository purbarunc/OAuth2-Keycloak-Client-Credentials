package com.codex.bookapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.codex.bookapi.domain.Book;

@Service
public class BookService {
	private final List<Book> listOfBooks = new ArrayList<>();

	@PostConstruct
	void init() {
		Book book1 = new Book(1, "Hibernate in Action", 650.00);
		Book book2 = new Book(2, "Spring Boot in Action", 750.00);
		listOfBooks.add(book1);
		listOfBooks.add(book2);
	}

	public Book getBookById(int id) {
		return listOfBooks.stream().filter(book -> book.id() == id).collect(toSingleton());
	}

	private <T> Collector<Book, ?, Book> toSingleton() {
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			if (list.size() != 1) {
				throw new IllegalStateException();
			}
			return list.get(0);
		});
	}
}
