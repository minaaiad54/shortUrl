package com.mina.aiad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrlRequest {
	
	private String longUrl;	
	private String apiKey;
	

}
