package com.purbarun.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.purbarun.oauth2.domain.Book;
import com.purbarun.oauth2.util.JwtUtility;

@Service
public class BookWebClientService {
	private final WebClient webClient = WebClient.builder().build();

	public Book getBook(int id) {
		return webClient.get().uri("http://localhost:8082/book?id=" + id)
				.headers(header -> header.setBearerAuth(JwtUtility.getJwtToken())).retrieve().bodyToMono(Book.class)
				.block();
	}
}
