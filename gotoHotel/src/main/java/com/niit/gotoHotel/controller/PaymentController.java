package com.niit.gotoHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dao.PaymentDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.PaymentDto;

public class PaymentController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	public PaymentDto initFlow()
	{
		return new PaymentDto();
	}
	
	public String addPayment(PaymentDto paymentDto)
	{
		
		paymentDao.add(paymentDto);
		
		
		return "yes" ;
	}
	
}
