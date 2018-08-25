package com.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.model.Category;

public interface CategoryDAO 
{
	public String addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
	public LinkedHashMap<Integer, String> getCategories();
}
