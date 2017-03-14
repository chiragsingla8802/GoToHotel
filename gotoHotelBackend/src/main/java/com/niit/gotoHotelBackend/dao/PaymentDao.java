package com.niit.gotoHotelBackend.dao;

import com.niit.gotoHotelBackend.dto.PaymentDto;
import com.niit.gotoHotelBackend.dto.UserDto;

public interface PaymentDao {
	public PaymentDto getPaymentDetails(UserDto userDto);
	public boolean add(PaymentDto paymentDto);
}
