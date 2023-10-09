package com.mina.aiad.service;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mina.aiad.model.ApiData;
import com.mina.aiad.model.UrlData;
import com.mina.aiad.repository.ApiDataRepository;
import com.mina.aiad.repository.UrlDataRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UrlService {

	@Autowired
	UrlDataRepository urlDataRepo;

	@Autowired
	ApiDataRepository apiDataRepository;
	
	private static final int NUM_CHARS_SHORT_LINK = 7;
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private Random random = new Random();

	public ResponseEntity<String> getLongUrl(String shortUrl) {
		
		if (shortUrl == null || shortUrl.isBlank() )
			return new ResponseEntity<String>("wrong URL",HttpStatus.BAD_REQUEST);

		UrlData urlfound = urlDataRepo.findByShortUrl(shortUrl);
		if (urlfound == null)
			return new ResponseEntity<String>("URL not found",HttpStatus.NOT_FOUND);

		urlfound.setVisitCount(urlfound.getVisitCount() + 1);
		urlDataRepo.save(urlfound);

		return new ResponseEntity<String>(urlfound.getLongUrl(),HttpStatus.FOUND);
	}

	public  ResponseEntity<String> getShortUrl(String longUrl, String apiKey) {
		// check apiKey is correct before getting the data
		if (!isApikeyCorrect(apiKey))
			return new ResponseEntity<String>("wrong ApiKey",HttpStatus.BAD_REQUEST);

		String shortUrl = generateShortUrl(longUrl);
		UrlData newUrlRecord = UrlData.builder().shortUrl(shortUrl).longUrl(longUrl).visitCount(0)
				.creationDate(new Date(System.currentTimeMillis())).build();

		urlDataRepo.save(newUrlRecord);
		return new ResponseEntity<String>(shortUrl,HttpStatus.CREATED);
	}

	private boolean isApikeyCorrect(String apikey) {
		return (apiDataRepository.findByApiKey(apikey) != null) ? true : false;
	}

	private String generateShortUrl(String longUrl) {
		  char[] result = new char[NUM_CHARS_SHORT_LINK];
		  while (true) {
		     for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++) {
		          int randomIndex = random.nextInt(ALPHABET.length() - 1);
		          result[i] = ALPHABET.charAt(randomIndex);
		      }
		       String shortLink = new String(result);
		        // make sure the short link isn't already used
		        if (urlDataRepo.findByShortUrl(shortLink)==null) {
		              return shortLink;
		          }
		      }
	}

	@PostConstruct
	private void postConstruct() {
		apiDataRepository.save(new ApiData(1,"abc","abc"));
	}
}
