package com.test.nimap.services;





import java.util.Optional;

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
		
		Optional<products>optional=prepo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null;
		}
	}



	@Override
	public products updateproduct(int id, products prod) {
		
		return prepo.findById(id).map(productfound->{
			productfound.setPname(prod.getPname());
			productfound.setPrice(prod.getPrice());
			productfound.setCategory(prod.getCategory());
			return prepo.save(productfound);
			
		}).orElseThrow(()->new RuntimeException("Product not found with Id:"+id));
	}



	@Override
	public boolean DelProdById(int pid) {
		Optional<products> oc = prepo.findById(pid);
		if(oc.isPresent()) {
		prepo.deleteById(pid);
		return true;
		}
		else 
		{
		    
		
		return false;
		}
	}

	
	
		
	
	

	
}
