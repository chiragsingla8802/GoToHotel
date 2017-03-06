package com.niit.gotoHotelBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServicesDto {

	/*
	 * getter and setter methods for private fields
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	 * private fields
	 */
	@Column(name="ID")
	private int category_id;
	@Column(name="PRODUCT-ID")
	private int product_id;
	private double price;
	private String location;
	private String description;
	private boolean active = true;
	
}
