package com;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.CategoryDAO;
import com.model.Category;
import com.dao.ProductDAO;
import com.model.Product;
import com.dao.SupplierDAO;
import com.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList",categoryDAO.getCategories());
		m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		return "ManageProduct";
	}
	
	@RequestMapping("/totalProductInfo/{productId}")
	public String showTotalProductDisplay(@PathVariable("productId") int productId, Model m)
	{
		Product product = productDAO.getProduct(productId);
		m.addAttribute("product",product);
		m.addAttribute("categoryName", categoryDAO.getCategory(product.getCategoryId()).getCategoryName());
		return "TotalProductDisplay";
	}
	
	@RequestMapping("/productDisplay")
	public String displayAllProducts(Model m)
	{
		m.addAttribute("productList",productDAO.listProducts());
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/ProductInsert",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile filedet,Model m)
	{
		/*
		This is the plus point of using Spring Form, we don't need to set each field of the object
		like we did in CategoryInsert:
		 	Category category = new Category();
			category.setCategoryName(categoryName);
			category.setCategoryDesc(categoryDesc);
		
			categoryDAO.addCategory(category);
		
		With SpringForm we just need to pass the Object to the addPRoduct method.
		
		Gagan use same for Category
		*/
		System.out.println("in insert");
		productDAO.addProduct(product);
		Product product1 = new Product();
		m.addAttribute(product1);	//to show blank product after save
		
		m.addAttribute("categoryList",categoryDAO.getCategories());
		m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		System.out.println("in insert saved and m done");
		//==> Adding the Image
		//F:\Dump\my data\NIITProjectEclpsOxgn\com.ecommfront
		String path="F:\\Dump\\my data\\NIITProjectEclpsOxgn\\com.ecommfront\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File file=new File(path);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte[] buffer=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(file);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo","Exception Arised:"+e.getMessage());
			}
		}
		else
		{
			m.addAttribute("errorInfo","There is System Problem No Image Insertion");
		}
		
		//==> Completed
		//System.out.println("Prodcut Added");
		System.out.println("in insert sbye");
		return "ManageProduct";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);	//to show blank product after save
		
		m.addAttribute("categoryList",categoryDAO.getCategories());
		m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		
		return "ManageProduct";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product = productDAO.getProduct(productId);
		m.addAttribute(product);
		m.addAttribute("categoryList",categoryDAO.getCategories());
		m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		//here we are calling a new page where user will see all fields in edit mode and he
		//can do modiifcation. we could also do it same we did in category.jsp
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{
		productDAO.addProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);	//to show blank product after save
		
		m.addAttribute("categoryList",categoryDAO.getCategories());
		m.addAttribute("supplierList",supplierDAO.getSuppliers());
		m.addAttribute("productList",productDAO.listProducts());
		
		return "ManageProduct";
		
	}
	/*
	public LinkedHashMap<Integer, String> getCategories()
	{
		List<Category> listCategories = categoryDAO.listCategories();
		LinkedHashMap<Integer, String> categoryData = new LinkedHashMap<Integer, String>();
		
		for(Category category:listCategories)
		{
			categoryData.put(category.getCategoryId(),category.getCategoryName());
		}
		return categoryData;
	}
	
	//supplierDAO
	public LinkedHashMap<Integer, String> getSuppliers()
	{
		List<Supplier> listSuppliers = supplierDAO.listSupplier();
		LinkedHashMap<Integer, String> supplierData = new LinkedHashMap<Integer, String>();
		
		for(Supplier supplier:listSuppliers)
		{
			supplierData.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return supplierData;
	}
	*/
	
}
