package com.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.model.Supplier;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier();
	public LinkedHashMap<Integer, String> getSuppliers();
}
