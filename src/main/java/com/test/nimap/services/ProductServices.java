package com.test.nimap.services;



import org.springframework.data.domain.Page;


import com.test.nimap.models.Products;
//interface for product service
public interface ProductServices {
	
	
	public Page<Products> getAllProducts(int offset,int pagesize);
	Products savepro(Products p);
	Products viewpbyid(int id);
	Products updateproduct(int id,Products prod);
	public boolean DelProdById(int pid);

}
