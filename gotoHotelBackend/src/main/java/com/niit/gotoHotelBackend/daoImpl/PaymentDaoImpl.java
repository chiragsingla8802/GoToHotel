package com.niit.gotoHotelBackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.PaymentDao;
import com.niit.gotoHotelBackend.dto.PaymentDto;
import com.niit.gotoHotelBackend.dto.UserDto;
@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl implements PaymentDao {

	  @Autowired
      SessionFactory sessionFactory;
	
	@Override
	public PaymentDto getPaymentDetails(UserDto userDto) {
		 return (PaymentDto)sessionFactory.getCurrentSession().createQuery("from PaymentDto where userDto=:userDto").setParameter("userDto",userDto).getSingleResult();
	}

	@Override
	public boolean add(PaymentDto paymentDto) {
		 try {
             sessionFactory.getCurrentSession().save(paymentDto);
             return true;
      } catch (Exception e) {
             e.printStackTrace();
             return false;
      }
	}

}
