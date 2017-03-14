package com.niit.gotoHotelBackend.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 8696961903109270296L;

	@Id
	@GeneratedValue
	private int cartId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private UserDto userDto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<CartItem> cartItems;

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	private int cartItemsCount;

	private double grandTotal;
	
	private boolean active=true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCartItemsCount() {
		return cartItemsCount;
	}

	public void setCartItemsCount(int cartItemsCount) {
		this.cartItemsCount = cartItemsCount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId =cartId;
	}

	public UserDto getUser() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItemsCount=" + cartItemsCount + ", grandTotal=" + grandTotal + "]";
	}

	

}
