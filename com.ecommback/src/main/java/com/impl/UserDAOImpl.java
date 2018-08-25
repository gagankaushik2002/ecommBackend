package com.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
			
			Criteria criteria = session.createCriteria(UserDetail.class);
			UserDetail userDetail = (UserDetail)criteria.add(Restrictions.eq("userName", userName))
			                             .uniqueResult();
			return userDetail;
		}
		catch(Exception e)
		{
			System.out.println("from impl error="+userName);
			System.out.println("tostring="+e.toString());
			System.out.println("only e="+e);
			return null;
		}
		
	}

}
