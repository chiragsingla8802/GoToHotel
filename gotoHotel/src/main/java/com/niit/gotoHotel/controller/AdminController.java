package com.niit.gotoHotel.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.ServicesDto;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ServicesDao servicesDao;
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value= "/")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");		
		mv.addObject("userClickAdmin", true);
		return mv;
	}
	
	@RequestMapping("/all/product")
	@ResponseBody
	public List <ServicesDto> getAllProducts()
	{
		return servicesDao.list();
	}
	
	
	@RequestMapping(value= "/edit/{id}/services")
	public ModelAndView editService(@PathVariable("id")int category_id)
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");
		mv.addObject("userClickAdmin", true);
		//System.out.println("service should come with data-------------------------------------------------");
		mv.addObject("servicesDto", servicesDao.get(category_id));
		return mv;
	}
	
	@RequestMapping(value= "/add/services")
	public ModelAndView addService()
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");		
		mv.addObject("userClickAdmin", true);	
		return mv;
	}
	
	/*@RequestMapping(value="/edit/{id}/service")
	public ModelAndView product(@PathVariable("id")int category_id){
		ModelAndView model =new ModelAndView("index");
		model.addObject("userClickAdmin","true");
		model.addObject("servicesDto", servicesDao.get(category_id));
		System.out.println("hiiiiiiii");
		return model;
	}*/
	
	/*@RequestMapping(value={"adminAddProduct"})
	public ModelAndView productcrud(){
		ModelAndView model =new ModelAndView("index");
		model.addObject("title","Admin");
		model.addObject("userClickAdmin","true");
		model.addObject("product",new Product());
		model.addObject("productList",productDAO.getAllProducts());
		return model;
	}*/
	
	@ModelAttribute("service")
	public ServicesDto getService(){
		return new ServicesDto();
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
    public String newServices(@ModelAttribute("servicesDto")ServicesDto servicesDto, ModelMap model) {
        
        return "admin";
    }*/
	
	
	
	@RequestMapping(value = "/save/services",  method = RequestMethod.POST)	
    public ModelAndView saveServices(@ModelAttribute("servicesDto") @Valid ServicesDto servicesDto, BindingResult result,@RequestParam String action){
		ServicesDto crud = new ServicesDto();    
		
		if(result.hasErrors()) {        	
			ModelAndView mv =new ModelAndView("index");
			mv.addObject("title","Admin");
			mv.addObject("userClickAdmin","true");
         return mv ;   
        }
		
		
		switch(action.toLowerCase()){
		case "add":
			if(!(crud.getFile().getOriginalFilename().equals(""))){
				crud.setLocation(uploadImage(crud.getFile()));
			}
			System.out.println("Image uploaded");
			servicesDao.add(servicesDto);
			crud=servicesDto;
			break;
		case "update":
			servicesDao.update(servicesDto);
			crud=servicesDto;
			break;
		case "delete":
			servicesDao.delete(servicesDto);
			crud=servicesDto;
			break;
		/*case "search":
			Product searchedProduct=productDAO.getProduct(product.getProductId());
			productResult=searchedProduct!=null?searchedProduct:new Product();
			break;*/
	}
	ModelAndView mv =new ModelAndView("index");
	mv.addObject("title","Admin");
	mv.addObject("userClickAdmin","true");
	mv.addObject("servicesDto", crud);
	mv.addObject("serviceDto", servicesDao.list());
	return mv;
}
	
	protected String uploadImage(MultipartFile multipart){
		System.out.println("Method reached");
		String folderToUpload="/resources/images/";
		String fileName=multipart.getOriginalFilename();
		String realPath=request.getServletContext().getRealPath(folderToUpload);
		if(!new File(realPath).exists()){
			new File(realPath).mkdirs();
		}
		String filePath=realPath+fileName;
		File destination=new File(filePath);
		try{
			multipart.transferTo(destination);
		}
		catch(Exception e){
			
		}
		return fileName;
	}
	
	/*@ModelAttribute("servicesadmin")
    public List<String> initializeProductAdminOptions() {
 
        List<String> servicesadmin = new ArrayList<String>();
        servicesadmin.add("Add");
        servicesadmin.add("Update");
        servicesadmin.add("Delete");
        return servicesadmin;
    }*/
}
