package com.niit.gotoHotelBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class CartItem implements Serializable {

	private static final long serialVersionUID = -8047736714754440907L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;

	private int quantity;

	private double totalPrice;

	@OneToOne(fetch = FetchType.EAGER)
	private ServicesDto servicesDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ServicesDto getServicesDto() {
		return servicesDto;
	}

	public void setServicesDto(ServicesDto servicesDto) {
		this.servicesDto = servicesDto;
	}

}
