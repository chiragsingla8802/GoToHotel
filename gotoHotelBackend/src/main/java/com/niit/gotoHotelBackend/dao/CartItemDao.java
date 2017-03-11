package com.niit.gotoHotelBackend.dao;

import java.util.List;

import com.niit.gotoHotelBackend.dto.CartItem;

public interface CartItemDao {

	boolean add(CartItem cartItem);
	boolean delete(int id);
	boolean update(CartItem cartItem);


	List<CartItem> userlist();	
	CartItem getUserDetail(int userId);
	CartItem getUserDetailByName(String name);
		
}
