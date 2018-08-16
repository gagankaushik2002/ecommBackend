package com.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDAO;
import com.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean registerUser(UserDetail userDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUserDetail(UserDetail userDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public UserDetail getUserDetail(String userName) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			UserDetail userDetail = (UserDetail)session.get(UserDetail.class,userName);
			return userDetail;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

}
