package com.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartItemDAO;
import com.model.CartItem;
import com.model.Category;

@Repository("CartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public CartItem getCartItem(int cartItemId) 
	{
		Session session= sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		session.close();
		return cartItem;
	
	}

	public List<CartItem> showCartItems(String userName) 
	{
		Session session= sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where userName=:myUserName and status='NA'");
		query.setParameter("myUserName", userName);
		List<CartItem> listCartItems=(List<CartItem>)query.list();
		session.close();
		return listCartItems;
	}
	
	public int calculateTotalPurchaseAmount(List<CartItem> cartItems)
	{
		int totalPurchaseAmount = 0;
		int count = 0;
		
		while(count<cartItems.size())
		{
			CartItem cartItem = cartItems.get(count);
			totalPurchaseAmount = totalPurchaseAmount+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
		return totalPurchaseAmount;
	}
	
	public boolean updateCartItems(String userName) 
	{
		//this will be called from Payment_JSP marking related cart items as paid
		System.out.println("in updateCartITems="+userName);
		try
		{
			Session session=sessionFactory.getCurrentSession();
			//here in update table name should be the same as given in your model class
			Query query  = session.createQuery("update CartItem set status='p' where username=:myUserName and status='NA'");
			query.setParameter("myUserName", userName);
			
			int row_eff = query.executeUpdate();
			System.out.println("in updateCartITems try row=-"+row_eff);
			if (row_eff>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("in catch="+e);
			return false;
		}
	}

}
