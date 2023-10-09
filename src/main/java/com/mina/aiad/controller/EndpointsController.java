package com.mina.aiad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mina.aiad.dto.ShortUrlRequest;
import com.mina.aiad.service.UrlService;

@CrossOrigin
@RestController
public class EndpointsController {
	
	@Autowired
	UrlService urlService;
	
	
	@GetMapping("/ping")
	public String ping() {

		return "pong";
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createShortUrl(@RequestBody ShortUrlRequest request) {
	
		return urlService.getShortUrl(request.getLongUrl(), request.getApiKey());
	}
	
	@GetMapping("{short_url}")
	public ResponseEntity<String> redirectUrl(@PathVariable("short_url") String shortUrl) {

		return urlService.getLongUrl(shortUrl);
	}

}
