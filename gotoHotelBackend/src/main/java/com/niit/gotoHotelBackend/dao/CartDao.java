package com.niit.gotoHotelBackend.dao;

import java.util.List;

import com.niit.gotoHotelBackend.dto.Cart;

public interface CartDao {

	Cart getUserDetail(int id);
	List<Cart> userlist();
	boolean add(Cart cart);
	boolean update(Cart cart);
	public Cart getUserDetailByid(int userId); 
	
}
