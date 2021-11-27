package com.novak.bestbuyinventoryservice.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.novak.bestbuyinventoryservice.model.bestbuy.ProductResponse;
import com.novak.bestbuyinventoryservice.service.SkuProducer;

@Service
public class BestBuyClient {


	public ResponseEntity<ProductResponse> sendRequest() {
		ResponseEntity<ProductResponse> responseEntity = null;



		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("https://api.bestbuy.com/v1/products(sku in(");
		urlBuilder.append(SkuProducer.getNext());
		urlBuilder.append("))?apiKey=vHITHZVP7QAdde1e9jaHoQWH&format=json");
		RestTemplate restTemplate = new RestTemplate();

		responseEntity = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, entity, ProductResponse.class);
		return responseEntity;

	}


}
