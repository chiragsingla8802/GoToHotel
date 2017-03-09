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
	 * servicesDto.setId(1); servicesDto.setPId(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Delhi"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // second static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setId(2); servicesDto.setPId(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Faridabad"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // third static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setId(3); servicesDto.setPId(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Mumbai"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto);
	 * 
	 * // fourth static category servicesDto = new ServicesDto();
	 * 
	 * servicesDto.setId(4); servicesDto.setPId(1);
	 * servicesDto.setPrice(1000); servicesDto.isActive();
	 * servicesDto.setLocation("Hydrabad"); servicesDto.setDescription(
	 * "5 star hotels"); services.add(servicesDto); }
	 * 
	 */

	/*
	 * @Override public ServicesDto get(int id) {
	 * 
	 * enhanced for loop
	 * 
	 * for(ServicesDto servicesDto : services){
	 * if(servicesDto.getId()==id) return servicesDto; }
	 * return null; }
	 */
	
	
	/*
	 * getting the list of category
	 */
	
	
	
	
	@Override
	public ServicesDto get(int id) {
		return sessionFactory.getCurrentSession().get(ServicesDto.class, Integer.valueOf(id));
	}
	
	

	@Override
	public List<ServicesDto> list() {
	/*	String selectActiveServicesDto = "FROM ServicesDto WHERE active = :active ";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveServicesDto);

		query.setParameter("active", true);

		return query.getResultList();*/
		return sessionFactory.getCurrentSession().createQuery("FROM ServicesDto WHERE active = TRUE").list();
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

	@Override
	public boolean delete(int id) {
		ServicesDto servicesDto = this.get(id);
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
