package com.mina.aiad.model;


import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UrlData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String shortUrl;
	private String longUrl;
	private String apiKey;
	private Date creationDate;
	private long visitCount;


}
