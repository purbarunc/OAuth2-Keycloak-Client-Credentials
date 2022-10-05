package com.purbarun.oauth2.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.purbarun.oauth2.domain.Book;
import com.purbarun.oauth2.util.JwtUtility;

@Service
public class BookRestTemplateService {
	private final RestTemplate restTemplate = new RestTemplateBuilder().build();

	public Book getBook(int id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Bearer " + JwtUtility.getJwtToken());
		ResponseEntity<Book> response = restTemplate.exchange("http://localhost:8082/book?id=" + id, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), Book.class);
		return response.getBody();
	}
}
