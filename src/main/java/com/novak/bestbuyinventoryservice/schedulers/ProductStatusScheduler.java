package com.novak.bestbuyinventoryservice.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.novak.bestbuyinventoryservice.model.bestbuy.ProductResponse;
import com.novak.bestbuyinventoryservice.service.ProductService;

@Configuration
@EnableScheduling
public class ProductStatusScheduler {

	@Autowired
	private ProductService bestBuyProductService;

	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(fixedRate = 5000)
	public void publishUpdates() {
		ResponseEntity<ProductResponse> results = bestBuyProductService.getProductData();
		if (results.getBody() != null) {
			template.convertAndSend("/topic/pushinstock", results.getBody().getProducts());
		} else {
			System.out.println("client response is null");
		}

	}

}
