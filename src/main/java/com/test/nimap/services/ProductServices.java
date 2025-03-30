package com.test.nimap.services;



import org.springframework.data.domain.Page;

import com.test.nimap.models.products;

public interface ProductServices {
	
	
	public Page<products> getAllProducts(int offset,int pagesize);
	products viewpbyid(int id);
	products updateproduct(int id,products prod);
	public boolean DelProdById(int pid);

}
