package com.niit.gotoHotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	// mapping for index page
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greeting", "welcome");
		return mv;
	}

	// mapping for About us page
	@RequestMapping(value = "/aboutUs")
	public ModelAndView aboutUs() {
		ModelAndView mv = new ModelAndView("aboutUs");
		mv.addObject("greeting", "welcome");
		return mv;
	}

	// mapping for contact us page
	@RequestMapping(value = "/contactUs")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("contactUs");
		mv.addObject("greeting", "welcome");
		return mv;
	}

	// mapping for login page
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("greeting", "welcome");
		return mv;
	}
	
	// mapping for product description page
		@RequestMapping(value = "/productDescription")
		public ModelAndView productDescription() {
			ModelAndView mv = new ModelAndView("productDescription");
			mv.addObject("greeting", "welcome");
			return mv;
		}

	// mapping for register page
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("greeting", "welcome");
		return mv;
	}

	// mapping for greeting page
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		ModelAndView mv = new ModelAndView("index");
		if (greeting == null) {
			greeting = "hello";
		}
		mv.addObject("greeting", greeting);
		return mv;
	}

	/*
	 * @RequestMapping(value="/test") public ModelAndView
	 * test(@RequestParam(value="greeting" ,required=false)String greeting){
	 * ModelAndView mv=new ModelAndView("index");
	 * mv.addObject("greeting",greeting); return mv; }
	 */

	/*
	 * @RequestMapping("/login") public ModelAndView login(){ ModelAndView
	 * mv=new ModelAndView("login");
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping("/register") public ModelAndView register(){ ModelAndView
	 * mv=new ModelAndView("register");
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping("/showProduct") public ModelAndView showProduct(){
	 * ModelAndView mv=new ModelAndView("showProduct");
	 * 
	 * return mv; }
	 */
}