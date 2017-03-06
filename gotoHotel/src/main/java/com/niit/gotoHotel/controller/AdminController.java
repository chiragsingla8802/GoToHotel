package com.niit.gotoHotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.ServicesDto;

@Controller
public class AdminController {
	
		@Autowired
		private ServicesDao servicesDao;

		/*
		 * For Admin
		 */
		@RequestMapping(value= "/admin")
		public ModelAndView admin()
		{
			ModelAndView mv = new ModelAndView("index"); // later this will be created as master page
			mv.addObject("title", "Admin");
			
			// passing the list of categories
			//mv.addObject("categories", categoryDAO.list());
			
			
			mv.addObject("userClickedAdmin", true);
			return mv;
		}	
		
		
		/*
	     * This method will serve as default GET handler.
	     *
	     */
	    @RequestMapping(method = RequestMethod.GET)
	    public String newRegistration(ModelMap model) {
	        ServicesDto servicesDto = new ServicesDto();
	        model.addAttribute("servicesDto", servicesDto);
	        return "admin";
	    }
	 
	    /*
	     * This method will be called on form submission, handling POST request
	     * It also validates the user input
	     */
	    @RequestMapping(value = "/admin/save/product",  method = RequestMethod.POST)
	    public String saveRegistration(@Valid ServicesDto servicesDto, BindingResult result, ModelMap model){
	 
	        if(result.hasErrors()) {
	                return "admin";
	        }
	 
	        model.addAttribute("success !!", "Product with code"+ servicesDto.getCategory_id()+" , - Registration completed successfully");
	        return "redirect:/admin";
	    }
	 
	    /*
	     * Method used to populate the Section list in view.
	     * Note that here you can call external systems to provide real data.
	     */
	    @ModelAttribute("productadminoptions")
	    public List<String> initializeProductAdminOptions() {
	 
	        List<String> sections = new ArrayList<String>();
	        sections.add("Add");
	        sections.add("Update");
	        sections.add("Delete");
	        return sections;
	    }	
		

	}

