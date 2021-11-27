package com.novak.bestbuyinventoryservice.service;

import org.springframework.http.ResponseEntity;

import com.novak.bestbuyinventoryservice.model.bestbuy.ProductResponse;

public interface ProductService {

	ResponseEntity<ProductResponse> getProductData();

}