package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.CategoryDAO;
import com.model.Category;


@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	boolean flag = false;
	
	@RequestMapping(value="/category")
	public String showCateogryPage(Model m)
	{
		flag=false;
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		m.addAttribute("flag",flag);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc, Model m)
	{
		flag=false;
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		m.addAttribute("flag",flag);
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId, Model m)
	{
		flag=false;
		Category category = (categoryDAO.getCategory(categoryId));
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		m.addAttribute("flag",flag);
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String EditCategory(@PathVariable("categoryId") int categoryId, Model m)
	{
		System.out.println("gaka 1 in edit category");
		flag=true;
		Category category = (categoryDAO.getCategory(categoryId));
		System.out.println("gaka 2 in edit category");
		m.addAttribute("categoryData",category);
		System.out.println("gaka 3 in edit category");
		m.addAttribute("flag",flag);
		System.out.println("gaka 4 in edit category");
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid")int categoryId,@RequestParam("catname") String categoryName,@RequestParam("catDesc")String categoryDesc, Model m)
	{
		flag=false;
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		m.addAttribute("flag",flag);
		return "Category";
	}
	
}
