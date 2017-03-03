package com.niit.gotoHotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping({"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("greeting","welcome");
		return mv;
	}
	
	@RequestMapping("/productDescription")
	public ModelAndView productDescription(){
		ModelAndView mv=new ModelAndView("productDescription");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView("login");
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(){
		ModelAndView mv=new ModelAndView("register");
		
		return mv;
	}
	
	@RequestMapping("/showProduct")
	public ModelAndView showProduct(){
		ModelAndView mv=new ModelAndView("showProduct");
		
		return mv;
	}
}
