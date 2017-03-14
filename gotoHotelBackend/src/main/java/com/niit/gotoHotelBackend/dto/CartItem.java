package com.niit.gotoHotelBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CartItem implements Serializable {

	private static final long serialVersionUID = -8047736714754440907L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="CartId")
	private Cart cart;

	private int quantity;
	
	private boolean active=true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private double totalPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private ServicesDto servicesDto;

	public int getCartItemId() {
		return cartItemId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ServicesDto getServicesDto() {
		return servicesDto;
	}

	public void setServicesDto(ServicesDto servicesDto) {
		this.servicesDto = servicesDto;
	}

}





/*@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = -904360230041854157L;

    @Id
    @GeneratedValue
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;


    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
} 
*/