package com.mina.aiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mina.aiad.model.ApiData;

@Repository
public interface ApiDataRepository extends JpaRepository<ApiData,Long> {
	
	ApiData findById(long apiDataId);
	ApiData findByApiKey (String apiKey);
}
