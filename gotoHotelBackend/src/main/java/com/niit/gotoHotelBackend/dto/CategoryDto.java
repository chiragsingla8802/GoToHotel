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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPId() {
		return pId;
	}
	public void setPId(int pId) {
		this.pId = pId;
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
		return "CategoryDto [id=" + id + ", name=" + name + ", pId=" + pId + ", price="
				+ price + ", active=" + active + "]";
	}



	/*
	 * private static fields
	 * */
	@Column(name="ID")
	private int id;
	private String name;
    @Column(name="PRODUCT-ID")
	private int pId;
    private double price;
	private boolean active=true;
	
}
