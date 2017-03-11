package com.niit.gotoHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gotoHotelBackend.dao.CategoryDao;
import com.niit.gotoHotelBackend.dao.ServicesDao;

@Controller
public class PageController {

	@Autowired
	private ServicesDao servicesDao;
	@Autowired
	private CategoryDao categoryDao;

	// mapping for index page
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
	//	System.out.println(prin.getName());
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	// mapping for About us page
	@RequestMapping(value = "/aboutUs")
	public ModelAndView aboutUs() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	// mapping for contact us page
	@RequestMapping(value = "/contactUs")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// mapping for login page
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String error, Model model) {
	if(error!=null) {
	model.addAttribute("error","Authentication Failed - Invalid credentials!");
	}
	model.addAttribute("title", "Login");
	return "login";
	}

	// mapping for product description page
	@RequestMapping(value = "/productDescription")
	public ModelAndView productDescription() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Services");

		// passing the list of services
		mv.addObject("services", servicesDao.list());
		mv.addObject("userClickServices", true);
		return mv;
	}

	// mapping for category page
	@RequestMapping(value = "/category")
	public ModelAndView category() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Category");

		// passing the list of categories
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickCategory", true);
		return mv;
	}

	// mapping for register page
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("title", "Register");
		mv.addObject("userClickRegister", true);
		return mv;
	}
	
	
	/*// mapping for admin page
		@RequestMapping(value = "/admin")
		public ModelAndView admin() {
			ModelAndView mv = new ModelAndView("index");
			JOptionPane.showMessageDialog(null, "coming");
			mv.addObject("title", "Admin");
			mv.addObject("userClickAdmin", true);
			return mv;
		}*/

	
	// mapping for show product page
	@RequestMapping(value = "/showProduct/{id}")
	public ModelAndView showProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");

		// category or services Dao to fetch the single category
		mv.addObject("categories", categoryDao.get(id));
		mv.addObject("services", servicesDao.get(id));
		mv.addObject("title", "Show Product");
		mv.addObject("userClickShowProduct", true);
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