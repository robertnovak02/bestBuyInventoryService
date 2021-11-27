package com.novak.bestbuyinventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.novak.bestbuyinventoryservice.client.BestBuyClient;
import com.novak.bestbuyinventoryservice.model.bestbuy.ProductResponse;

@Service
public class BestBuyProductServiceImpl implements ProductService {

	@Autowired
	private BestBuyClient bestBuyClient;

	@Override
	public ResponseEntity<ProductResponse> getProductData() {
		return bestBuyClient.sendRequest();
	}

}
