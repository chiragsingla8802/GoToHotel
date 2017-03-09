package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.CategoryDao;
import com.niit.gotoHotelBackend.dto.CategoryDto;
@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	 private SessionFactory sessionFactory;  
	
	/*
	private static List<CategoryDto> categories = new ArrayList<>();

	static {

		CategoryDto categoryDto = new CategoryDto();

		// first static category
		categoryDto = new CategoryDto();
		
		categoryDto.setId(1);
		categoryDto.setName("5 star");
		categoryDto.setPId(1);
		categoryDto.setPrice(1000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// second static category
		categoryDto = new CategoryDto();
		
		categoryDto.setId(2);
		categoryDto.setName("tourist destination hotels");
		categoryDto.setPId(1);
		categoryDto.setPrice(2000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// third static category
		categoryDto = new CategoryDto();
		
		categoryDto.setId(3);
		categoryDto.setName("low cost");
		categoryDto.setPId(1);
		categoryDto.setPrice(3000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// fourth static category
		categoryDto = new CategoryDto();
		
		categoryDto.setId(4);
		categoryDto.setName("sharing one");
		categoryDto.setPId(1);
		categoryDto.setPrice(4000);
		categoryDto.isActive();
		categories.add(categoryDto);
	}

	*/

	


	



	/*@Override
	public CategoryDto get(int id) {
		
		 *enhanced for loop
		 *
		 * for(CategoryDto categoryDto : categories){
			if(categoryDto.getId()==id)
				return categoryDto;
		}
		return null;
	}*/
	
	@Override
	public List<CategoryDto> list() {
		
		//String selectActiveCategoryDto = "FROM CategoryDto WHERE active = :active ";
		
		/*Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategoryDto);
		
		query.setParameter("active", true);
		
		//return sessionFactory.getCurrentSession().createQuery("FROM CategoryDto",CategoryDto.class).getResultList();
	    return query.getResultList();*/
		return sessionFactory.getCurrentSession().createQuery("FROM CategoryDto",CategoryDto.class).getResultList();		
	}


	@Override
	public boolean add(CategoryDto categoryDto) {
		try{
			// add the category to database table
			sessionFactory.getCurrentSession().persist(categoryDto);
			return true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			return false;
			}
		
	}

	@Override
	public CategoryDto get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(CategoryDto.class,Integer.valueOf(id));
	}


	@Override
	public boolean update(CategoryDto categoryDto) {
		try{
			// add the category to database table
			sessionFactory.getCurrentSession().update(categoryDto);
			return true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			return false;
			}
	}



	@Override
	public boolean delete(CategoryDto categoryDto) {
		
		categoryDto.setActive(false);
		try{
			// add the category to database table
			sessionFactory.getCurrentSession().update(categoryDto);
			return true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			return false;
			}
	}
}