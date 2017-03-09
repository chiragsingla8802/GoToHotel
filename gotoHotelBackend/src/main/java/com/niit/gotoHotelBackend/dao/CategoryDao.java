package com.niit.gotoHotelBackend.dao;

import java.util.List;
import com.niit.gotoHotelBackend.dao.CategoryDao;
import com.niit.gotoHotelBackend.dto.CategoryDto;

public interface CategoryDao
{
	boolean add(CategoryDto categoryDto);
	boolean update(CategoryDto categoryDto);
	boolean delete(CategoryDto categoryDto);
	
	List<CategoryDto> list();	
	CategoryDto get(int id);
	
}
