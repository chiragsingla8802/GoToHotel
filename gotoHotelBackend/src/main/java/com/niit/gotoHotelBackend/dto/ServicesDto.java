package com.niit.gotoHotelBackend.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServicesDto {

	/*
	 * getter and setter methods for private fields
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public int getServiceQuantity() {
		return serviceQuantity;
	}
	public void setServiceQuantity(int serviceQuantity) {
		this.serviceQuantity = serviceQuantity;
	}
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}





	
	/*
	 * private fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String pid;
	private double price;
	
	private String location;
	
	private String description;
	
	private int serviceQuantity;
	
	private String image_url;	
	
	private boolean active = true;
	
	@Transient
	MultipartFile file;
	
	 @OneToMany(mappedBy = "servicesDto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JsonIgnore
	    private List<CartItem> cartItemList;

}
