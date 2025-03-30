package com.test.nimap.services;



import org.springframework.data.domain.Page;

import com.test.nimap.models.products;

public interface ProductServices {
	
	
	public Page<products> getAllProducts(int offset,int pagesize);

}
