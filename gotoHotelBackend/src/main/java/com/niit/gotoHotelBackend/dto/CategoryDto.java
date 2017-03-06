package com.niit.gotoHotelBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
	@Override
	public String toString() {
		return "CategoryDto [category_id=" + category_id + ", name=" + name + ", product_id=" + product_id + ", price="
				+ price + ", active=" + active + "]";
	}



	/*
	 * private static fields
	 * */
	@Column(name="ID")
	private int category_id;
	private String name;
    @Column(name="PRODUCT-ID")
	private int product_id;
    private double price;
	private boolean active=true;
	
}
