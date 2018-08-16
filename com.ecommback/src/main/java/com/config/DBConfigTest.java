package com.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDAO;
import com.model.Category;

public class DBConfigTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		Category category=new Category();
		category.setCategoryName("Mobilegagan");
		category.setCategoryDesc("Samsung Mobilesgaga");
		
		categoryDAO.addCategory(category);
//		
		System.out.println("Category Object Saved:");
		
	}
}
