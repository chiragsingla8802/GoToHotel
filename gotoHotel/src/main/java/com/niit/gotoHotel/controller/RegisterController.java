package com.niit.gotoHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.CartDto;
import com.niit.gotoHotelBackend.dto.UserDto;
@Component
public class RegisterController {

	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	public UserDto initFlow()
	{
		return new UserDto();
	}
	
	
	
	public boolean addUser(UserDto userDto)
	{
		CartDto cartDto = new CartDto();
		userDao.add(userDto);
		cartDao.add(cartDto);
		
		return true ;
	}
	
}
