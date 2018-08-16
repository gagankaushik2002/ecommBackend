package com.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{

	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) 
	{
		System.out.println("hello from add produc t");
		try
		{
			System.out.println("hello from add produc try ="+product.getProductDesc());
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			System.out.println("hello from add produc t");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("hello from add produc err ="+e.getMessage());
			return false;
		}
		
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productId) {
		try
		{
			Session session= sessionFactory.openSession();
			Product product=(Product)session.get(Product.class,productId);
			session.close();
			return product;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Product> listProducts() {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Product");
			List<Product> listProducts=query.list();
			session.close();
			return listProducts;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Product> listProductsByCategory(Category categoryId) {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Product where categoryId=:catid");
			query.setParameter("catid",categoryId);
			List<Product> listProducts=query.list();
			session.close();
			return listProducts;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Product> listProductsBySupplier(Supplier supplierId) {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Product where supplierId=:suplrid");
			query.setParameter("suplrid",supplierId);
			List<Product> listProducts=query.list();
			session.close();
			return listProducts;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
		
}
