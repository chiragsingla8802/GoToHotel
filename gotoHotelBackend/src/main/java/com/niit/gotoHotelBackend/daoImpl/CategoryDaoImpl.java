package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
		categoryDto.setCategory_id(1);
		categoryDto.setName("5 star");
		categoryDto.setProduct_id(1);
		categoryDto.setPrice(1000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// second static category
		categoryDto = new CategoryDto();
		
		categoryDto.setCategory_id(2);
		categoryDto.setName("tourist destination hotels");
		categoryDto.setProduct_id(1);
		categoryDto.setPrice(2000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// third static category
		categoryDto = new CategoryDto();
		
		categoryDto.setCategory_id(3);
		categoryDto.setName("low cost");
		categoryDto.setProduct_id(1);
		categoryDto.setPrice(3000);
		categoryDto.isActive();
		categories.add(categoryDto);

		// fourth static category
		categoryDto = new CategoryDto();
		
		categoryDto.setCategory_id(4);
		categoryDto.setName("sharing one");
		categoryDto.setProduct_id(1);
		categoryDto.setPrice(4000);
		categoryDto.isActive();
		categories.add(categoryDto);
	}

	*/

	


	



	/*@Override
	public CategoryDto get(int category_id) {
		
		 *enhanced for loop
		 *
		 * for(CategoryDto categoryDto : categories){
			if(categoryDto.getCategory_id()==category_id)
				return categoryDto;
		}
		return null;
	}*/
	
	@Override
	public List<CategoryDto> list() {
		
		String selectActiveCategoryDto = "FROM CategoryDto WHERE active = :active ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategoryDto);
		
		query.setParameter("active", true);
		
		//return sessionFactory.getCurrentSession().createQuery("FROM CategoryDto",CategoryDto.class).getResultList();
	    return query.getResultList();
	    		
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
	public CategoryDto get(int category_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(CategoryDto.class,Integer.valueOf(category_id));
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