package com.dao;
import java.util.List;

import com.model.Category;
import com.model.Product;
import com.model.Supplier;

public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	
	public Product getProduct(int productId);
	public List<Product> listProducts();
	public List<Product> listProductsByCategory(Category categoryId);
	public List<Product> listProductsBySupplier(Supplier supplierId);
}