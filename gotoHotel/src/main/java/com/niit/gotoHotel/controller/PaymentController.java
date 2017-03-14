package com.niit.gotoHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.PaymentDto;

public class PaymentController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	public Cart initFlow()
	{
		return new Cart();
	}
	
	public void savePayment(Cart cart,PaymentDto paymentDto){
		cart.
	}
	
}
