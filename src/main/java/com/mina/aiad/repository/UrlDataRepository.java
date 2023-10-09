package com.mina.aiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mina.aiad.model.UrlData;



@Repository
public interface UrlDataRepository extends JpaRepository<UrlData,Long> {
	
	 UrlData findById(long urlDataId);
	 UrlData findByShortUrl(String shortUrl);

}
