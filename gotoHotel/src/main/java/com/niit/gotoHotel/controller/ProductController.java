package com.niit.gotoHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.gotoHotelBackend.dao.CategoryDao;
import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.CategoryDto;
import com.niit.gotoHotelBackend.dto.ServicesDto;

@Controller
public class ProductController {

	@Autowired 
	CategoryDao categoryDao;
	
	@RequestMapping("/pro/all/product1")
	
	public @ResponseBody List<CategoryDto> getCategoryProduct(){
		return categoryDao.list();
	}
	
	@Autowired 
	ServicesDao servicesDao;
	
	@RequestMapping("/pro/all/product2")
	
	public @ResponseBody List<ServicesDto> getServicesProducts(){
		return servicesDao.list();
	}

}
