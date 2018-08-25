package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ProductDAO;
import com.model.Product;

@Controller
public class indexController 
{
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/")
	//@RequestMapping(value="/home")
	public String showProductPage(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		//m.addAttribute("categoryList",categoryDAO.getCategories());
		//m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		return "index";
	}
}
