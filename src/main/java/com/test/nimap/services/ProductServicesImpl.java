package com.test.nimap.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.nimap.models.products;

import com.test.nimap.repository.ProductRepository;
@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductRepository prepo;
	
	

	@Override
	public Page<products> getAllProducts(int offset, int pagesize) {
		
		Page<products>products= prepo.findAll(PageRequest.of(offset, pagesize));
		return products;
	}



	@Override
	public products viewpbyid(int id) {
		
		return prepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
	}
	

	
}
