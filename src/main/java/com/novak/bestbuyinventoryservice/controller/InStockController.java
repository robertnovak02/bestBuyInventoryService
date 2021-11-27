package com.novak.bestbuyinventoryservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class InStockController {

	@MessageMapping("/instock")
	@SendTo("/topic/pushinstock")
	public String instock() {

		return "welcome";
	}

}
