package com.niit.gotoHotelBackend.dao;

import java.util.List;

import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.CartItem;

public interface CartItemDao {

	boolean add(CartItem cartItem);
	boolean delete(CartItem cartItem);
	boolean update(CartItem cartItem);


	List<CartItem> userlist(Cart cart);	
	CartItem getUserDetail(int userId);
	CartItem getUserDetailByName(String name);
		
}
