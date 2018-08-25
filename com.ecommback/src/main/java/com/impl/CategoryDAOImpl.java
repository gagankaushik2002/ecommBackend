package com.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDAO;
import com.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public String addCategory(Category category) 
	{
		String saveStatus;
		System.out.println("from daoimpl="+category.getCategoryName());
		if (category.getCategoryName()=="")
		{
			saveStatus =  "BlankName";
		}
		else
		{
			try
			{
				sessionFactory.getCurrentSession().save(category);
				saveStatus = "Saved";
			}
			catch(Exception e)
			{
				saveStatus =  "CouldNotSave-"+e;
			}
		}
		return saveStatus;
	}

	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Category getCategory(int categoryId) 
	{
		try
		{
			Session session= sessionFactory.getCurrentSession();
			Category category=(Category)session.get(Category.class,categoryId);
			return category;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Category> listCategories() 
	{
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Category");
			List<Category> listCategories=query.list();
			session.close();
			return listCategories;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public LinkedHashMap<Integer, String> getCategories()
	{
		List<Category> listCategories = this.listCategories();
		LinkedHashMap<Integer, String> categoryData = new LinkedHashMap<Integer, String>();
		
		for(Category category:listCategories)
		{
			categoryData.put(category.getCategoryId(),category.getCategoryName());
		}
		return categoryData;
	}

}
