package com.novak.bestbuyinventoryservice.model;

import java.time.LocalDateTime;

public class Product {
	private String name;
	private String description;
	private String sku;
	private String addToCartURL;
	private String availability;
	private LocalDateTime lastUpdate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getAddToCartURL() {
		return addToCartURL;
	}

	public void setAddToCartURL(String addToCartURL) {
		this.addToCartURL = addToCartURL;
	}
}
