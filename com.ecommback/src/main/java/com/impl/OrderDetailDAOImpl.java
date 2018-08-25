package com.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDetailDAO;
import com.model.OrderDetail;


@Repository("OrderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertOrderDetail(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
