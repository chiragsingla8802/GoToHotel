package com.niit.gotoHotel.controller;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ModelAttribute("servicesDto")
	public ServicesDto getProdct() {
		return new ServicesDto();
	}
	
	
	@RequestMapping(value= "/adminpage")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");
		mv.addObject("servicesDto", new ServicesDto());
		mv.addObject("userClickAdmin", true);
		return mv;
	}
	
	
	
	@RequestMapping("/all/product")
	@ResponseBody
	public List <ServicesDto> getAllProducts()
	{
		return servicesDao.list();
	}
	
	@RequestMapping(value= "/add/services")
	public ModelAndView addService()
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");		
		mv.addObject("userClickAdmin", true);	
		mv.addObject("servicesDto", new ServicesDto());
		return mv;
	}
	
	@RequestMapping(value= "/edit/{id}/services")
	public ModelAndView editService(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");
		mv.addObject("userClickAdmin", true);
		//System.out.println("service should come with data-------------------------------------------------");
		mv.addObject("servicesDto", servicesDao.get(id));
		return mv;
	}
	
	
	@RequestMapping(value = "/save/services",  method = RequestMethod.POST)	
    public String saveServices( @ModelAttribute("servicesDto")  ServicesDto servicesDto, BindingResult result,Model model){   
	System.out.println("------------- update handler reached-------------");
	System.out.println(servicesDto.getDescription());
	System.out.println("------------- Add product initiategfnhgk,hmjgmgnfgd -------------");
		
	
	if(result.hasErrors()) 
	{
		System.out.println("Result has errors  !!!!");
		model.addAttribute("title", "Admin");
		model.addAttribute("addServicesFailed", true);
        return "index";
	}
	servicesDto.setImage_url(servicesDto.getPid().toString()+".jpg");
	System.out.println("Result has no Errors  : " + servicesDto.getFile().getName());
		
	if (!servicesDto.getFile().isEmpty()) 
	{
		System.out.println("------------- update file reached-------------");
		
		// If the file is not empty
		String realPath = request.getServletContext().getRealPath("/assets/images");
		
		System.out.println("Real path: " + realPath);
		File dir = new File(realPath + File.separator);
		if (!dir.exists())
			dir.mkdirs(); // if dest path/dirs do not exist - create them
		String orgName = servicesDto.getPid();
		String filePath = realPath + File.separator + orgName + ".jpg";
		File dest = new File(filePath);
		System.out.println("Dest file path: " + dest);
		System.out.println("Dest file path: " + filePath);

		try{
			servicesDto.getFile().transferTo(dest);
		}
		catch(Exception ex) 
		{
			System.out.println("Inside exception in image upload....");
		}
	}
	else{
		System.out.println("------------- else reached-------------");
		
	}
	
		System.out.println("Inside Save Product ....");
		if(servicesDto.getId()== 0)
		{
			System.out.println("Adding services...");
			servicesDao.add(servicesDto);
		}
		else
		{
			System.out.println("Updating services");
			servicesDao.update(servicesDto);
		}
		
		
        return "redirect:/admin/adminpage";
	}
	
	@RequestMapping(value= "/delete/{id}/services" , method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id)
	{
	
		System.out.println("Inside Delete Product ....");
		ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin");
		mv.addObject("userClickAdmin", true);
		System.out.println("Deleteing product with id : " + id);
		servicesDao.delete(id);
		return "redirect:/admin/adminpage";
	
	}
}

	
	
	
	
	
	
	
	
/*package com.niit.gotoHotel.controller;*/

/*import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	
	@RequestMapping("/all/data")
	@ResponseBody
	public  List <ServicesDto> getAllProducts(){
		return servicesDao.list();
	}

	
	@RequestMapping(value = "/")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("title", "Admin");

		mv.addObject("userClickAdmin", true);
		return mv;
	}


	@RequestMapping(value = "/adminpage")
	public ModelAndView productmanagement() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Admin - Product Management");
		mv.addObject("servicesDto", new ServicesDto());

		mv.addObject("userClickAdmin", true);
		return mv;
	}

	@RequestMapping(value = "/add/services")
	public ModelAndView addProduct() {
	ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin - Product Management");
		mv.addObject("userClickAdmin", true);
		mv.addObject("servicesDto", new ServicesDto());
		return mv;
	}

	@RequestMapping(value = "/edit/{id}/services")
	public ModelAndView editProduct(@PathVariable("id") int id) {
	ModelAndView mv = new ModelAndView("index"); 
		mv.addObject("title", "Admin - Service Management");
		mv.addObject("userClickAdmin", true);
		ServicesDto servicesDto = servicesDao.get(id);
		mv.addObject("servicesDto", servicesDto);		
		return mv;
	}

	
	@RequestMapping(value= "/save/product" , method = RequestMethod.POST)
	public String saveProduct( @ModelAttribute("servicesDto" )@Valid ServicesDto servicesDto, BindingResult result, Model model)
	{
		System.out.println("Inside save product method !!!!");
		
		
		if(result.hasErrors()) 
		{
			System.out.println("Result has errors  !!!!");
			model.addAttribute("title", "Admin - Service Management");
			model.addAttribute("addProductFailed", true);
	        return "index";
		}		
		
		servicesDto.setImage_url(servicesDto.getPid().toString()+".jpg");
		System.out.println("Result has no Errors  : " + servicesDto.getFile().getName());
		
		//Adding the file upload related coding here
		if (!product.getImagempfile().isEmpty()) 
		{
			// If the file is not empty
			String realPath = request.getServletContext().getRealPath("/resources/images");
			
			System.out.println("Real path: " + realPath);
			File dir = new File(realPath + File.separator);
			if (!dir.exists())
				dir.mkdirs(); // if dest path/dirs do not exist - create them
			String orgName = product.getCode();
			String filePath = realPath + File.separator + orgName + ".jpg";
			File dest = new File(filePath);
			
			System.out.println("Dest file path: " + filePath);

			try{
				product.getImagempfile().transferTo(dest);
			}
			catch(Exception ex) 
			{
				System.out.println("Inside exception in image upload....");
			}
		}
		System.out.println("Inside Save Product ....");
		if(product.getId() == 0)
		{
			System.out.println("Adding product...");
			productDAO.add(product);
		}
		else
		{
			System.out.println("Updagint product");
			productDAO.update(product);
		}
        return "redirect:/admin/show/product/management";
	}


	@RequestMapping(value= "/delete/{id}/product" , method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id)//, @ModelAttribute("product" ) Product product)
	{
	
		System.out.println("Inside Delete Product ....");
		ModelAndView mv = new ModelAndView("page"); // internally productmanagement.jsp will be shown 
		mv.addObject("title", "Admin - Product Management");
		
		mv.addObject("userClickedAdminProductManagement", true);
		
		//productDAO.get(id);
		System.out.println("Delete ing product with id : " + id);
		productDAO.delete(id);

		return "redirect:/admin/show/product/management";
	
	}
	}
	
	*/
	
		
	
	
	
	
	
	
	
	
	/*
	
	
	
	
	@ModelAttribute("service")
	public ServicesDto getService() {
		return new ServicesDto();
	}

	
	 * Mapping for add product.
	 
	@RequestMapping("/addProduct")
	public String addProducts(@ModelAttribute("service") @Valid ServicesDto servicesDto, BindingResult result,
			Model model) {
		System.out.println("------- Add Product Controller Initiated -------");
		if (!result.hasErrors()) {
			System.out.println("------- Add Product Functionality Initiated -------");

			if (!servicesDto.getImage_url().isEmpty()) {
				try {
					
					 *  Creating the directory in the server context to store.
					 * 
					String imagePath = request.getServletContext().getRealPath("/resources/images");
					System.out.println("------- Context Path set -------");
					File dir = new File(imagePath + File.separator);
					System.out.println("------- Directory set to" +dir+ "-------");
					if (!dir.exists())
						dir.mkdirs();
					String orgName = servicesDto.getPid();
                    String filePath =  imagePath +File.separator+ orgName+".jpg";
                    File dest = new File(filePath);
                    System.out.println("------- Image uploaded to " +dest+ "-------");
                    servicesDto.getImage_url().transferTo(dest);

				} catch (Exception e) {
					System.out.println("You failed to upload " + servicesDto.getImage_url() + " => " + e.getMessage());
				}
			} else {
				System.out.println("Upload Failed");
			}

			servicesDao.add(servicesDto);
			System.out.println("-------Product Saved-------");
			model.addAttribute("servicesDto", servicesDao.list());
			//model.addAttribute("category", categoryDao.getCategoryList());
			model.addAttribute("message","Product added successfully.");
			model.addAttribute("userClickAdmin", true);
			model.addAttribute("title", "Admin");
			return "index";
		} else

		{
			System.out.println("-------Product Save Failed-------");
			model.addAttribute("servicesDto", servicesDao.list());
		//	model.addAttribute("category", categoryDao.getCategoryList());
			model.addAttribute("message","Product was not added.");
			model.addAttribute("title", "Admin");
			model.addAttribute("userClickAdmin", true);
			return "index";
		}
	}
	
	@RequestMapping("update/product/{pId}")
	public String getProUpdate(@PathVariable("pId")int id,Model model){
		model.addAttribute("pro",productDao.getProductById(id));
	//	model.addAttribute("category", categoryDao.getCategoryList());
		model.addAttribute("title", "admin");
		model.addAttribute("admin", true);
		return "master";
	}

	
	 * Constructor of Product mapped with the form.
	 
	@ModelAttribute("updateProductCommand")
	public Product getUpdateProdct() {
		return new Product();
	}

	
	 * Mapping for Update product.
	 
	@RequestMapping("/updateProduct")
	public String updateProducts(@ModelAttribute("updateProductCommand") @Valid Product product, BindingResult result,
			Model model) {

		if (!result.hasErrors()) {
			productDao.updateProduct(product);
			System.out.println("-------Product Updated-------");
			model.addAttribute("product", productDao.getProductList());
		//	model.addAttribute("category", categoryDao.getCategoryList());
			model.addAttribute("home", true);
			model.addAttribute("title", "Home");
			return "master";
		} else {
			System.out.println("-------Product Update Failed-------");
			model.addAttribute("product", productDao.getProductList());
	//		model.addAttribute("category", categoryDao.getCategoryList());
			model.addAttribute("title", "admin");
			model.addAttribute("admin", true);
			return "master";
		}
	}

}
	
	
	
		
		switch(action.toLowerCase()){
		case "add":
			if(!(crud.getFile().getOriginalFilename().equals(""))){
				crud.setImage_url(uploadImage(crud.getFile()));
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
		case "search":
			Product searchedProduct=productDAO.getProduct(product.getProductId());
			productResult=searchedProduct!=null?searchedProduct:new Product();
			break;
	
	 * } ModelAndView mv =new ModelAndView("index");
	 * mv.addObject("title","Admin"); mv.addObject("userClickAdmin","true");
	 * mv.addObject("servicesDto", crud); mv.addObject("serviceDto",
	 * servicesDao.list()); return mv; }
	 
	
	@RequestMapping(value="/edit/{id}/service")
	public ModelAndView product(@PathVariable("id")int id){
		ModelAndView model =new ModelAndView("index");
		model.addObject("userClickAdmin","true");
		model.addObject("servicesDto", servicesDao.get(id));
		System.out.println("hiiiiiiii");
		return model;
	}
	
	@RequestMapping(value={"adminAddProduct"})
	public ModelAndView productcrud(){
		ModelAndView model =new ModelAndView("index");
		model.addObject("title","Admin");
		model.addObject("userClickAdmin","true");
		model.addObject("product",new Product());
		model.addObject("productList",productDAO.getAllProducts());
		return model;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
    public String newServices(@ModelAttribute("servicesDto")ServicesDto servicesDto, ModelMap model) {
        
        return "admin";
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
	
	@ModelAttribute("servicesadmin")
    public List<String> initializeProductAdminOptions() {
 
        List<String> servicesadmin = new ArrayList<String>();
        servicesadmin.add("Add");
        servicesadmin.add("Update");
        servicesadmin.add("Delete");
        return servicesadmin;
    }
}
*/