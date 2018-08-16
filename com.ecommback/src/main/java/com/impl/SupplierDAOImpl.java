package com.impl;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SupplierDAO;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	//@Override
	public boolean addSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	//@Override
	public boolean updateSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//@Override
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//@Override
	public Supplier getSupplier(int supplierId) {
		try
		{
			Session session= sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
			session.close();
			return supplier;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	//@Override
	public List<Supplier> listSupplier() {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> listSupplier=query.list();
			session.close();
			return listSupplier;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public LinkedHashMap<Integer, String> getSuppliers()
	{
		List<Supplier> listSuppliers = this.listSupplier();
		LinkedHashMap<Integer, String> supplierData = new LinkedHashMap<Integer, String>();
		
		for(Supplier supplier:listSuppliers)
		{
			supplierData.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return supplierData;
	}

}
