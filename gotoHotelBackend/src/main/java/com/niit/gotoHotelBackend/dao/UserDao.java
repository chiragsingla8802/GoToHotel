package com.niit.gotoHotelBackend.dao;

import java.util.List;

import com.niit.gotoHotelBackend.dto.UserDto;

public interface UserDao {


	boolean add(UserDto userDto);
	boolean delete(int id);
	boolean update(UserDto userDto);


	List<UserDto> userlist();	
	UserDto getUserDetail(int userId);
	UserDto getUserDetailByName(String name);

}
