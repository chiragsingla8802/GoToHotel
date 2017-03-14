package com.niit.gotoHotelBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PaymentDto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@Email
	private String email;
	@NotNull
	private String phone;
	@CreditCardNumber
	private String cardNo;
	@NotEmpty
	private String cardName;
	@Min(value = 01)
	@Max(value = 12)
	private int mm;
	@Min(value = 13)
	@Max(value = 32)
	private int yy;

	@OneToOne(cascade = CascadeType.ALL)
	private UserDto userDto;

}
