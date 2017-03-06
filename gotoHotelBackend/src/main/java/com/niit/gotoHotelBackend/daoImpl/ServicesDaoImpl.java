package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.ServicesDto;

@Repository("servicesDao")
@Transactional
public class ServicesDaoImpl implements ServicesDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<ServicesDto> services = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * ServicesDto servicesDto = new ServicesDto();
	 * 
	 * // first static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setCategory_id(1); servicesDto.setProduct_id(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Delhi"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // second static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setCategory_id(2); servicesDto.setProduct_id(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Faridabad"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // third static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setCategory_id(3); servicesDto.setProduct_id(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Mumbai"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // fourth static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setCategory_id(4); servicesDto.setProduct_id(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Hydrabad"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto); }
	 * 
	 */

	/*
	 * @Override public ServicesDto get(int category_id) {
	 * 
	 * enhanced for loop
	 * 
	 * for(ServicesDto servicesDto : services){
	 * if(servicesDto.getCategory_id()==category_id) return servicesDto; }
	 * return null; }
	 */
	
	
	/*
	 * getting the list of category
	 */
	@Override
	public List<ServicesDto> list() {
		String selectActiveServicesDto = "FROM ServicesDto WHERE active = :active ";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveServicesDto);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * adding the single category
	 */

	@Override
	public boolean add(ServicesDto servicesDto) {
		try {
			// add the category to database table
			sessionFactory.getCurrentSession().persist(servicesDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * get the single category
	 */

	@Override
	public ServicesDto get(int category_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(ServicesDto.class, Integer.valueOf(category_id));
	}

	/*
	 * updating the single category
	 */

	@Override
	public boolean update(ServicesDto servicesDto) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(servicesDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * deleting the single category
	 */
	@Override
	public boolean delete(ServicesDto servicesDto) {

		servicesDto.setActive(false);
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(servicesDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
