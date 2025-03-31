package com.test.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.nimap.models.Categories;
import com.test.nimap.models.Products;

import com.test.nimap.repository.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductRepository prepo;  

	@Autowired
	CategoryServices categoryServices;  //category service object

	//find all products with pagination
	@Override
	//provide page and page size
	public Page<Products> getAllProducts(int offset, int pagesize) {

		Page<Products> products = prepo.findAll(PageRequest.of(offset, pagesize));
		return products;
	}

	//get product by id
	@Override
	public Products viewpbyid(int id) {

		Optional<Products> optional = prepo.findById(id);
		if (optional.isPresent()) {

//			products product = optional.get();
//			product.setCategoryName(product.getCategory().getCname());
			return optional.get();
		} else {
			return null;
		}
	}

	//update product by id
	@Override
	public Products updateproduct(int id, Products prod) {
		Optional<Products>opprod=prepo.findById(id);
		if(opprod.isPresent())
		{
			Products cat=opprod.get();
			cat.setPname(prod.getPname());
			cat.setPrice(prod.getPrice());
			
			int newcid=prod.getCategory().getCid();
			Categories categories=categoryServices.viewcbyid(newcid);
			if(categories!=null)
			{
				cat.setCategory(categories);
			}
			prepo.save(cat);
			return cat;
		}
	
		return null;

		
	}

	//delete product by id
	@Override
	public boolean DelProdById(int pid) {
		Optional<Products> oc = prepo.findById(pid);
		if (oc.isPresent()) {
			prepo.deleteById(pid);
			return true;
		} else {

			return false;
		}
	}

	@Override
	public Products savepro(Products p) {

		int categoryId = p.getCategory().getCid();
		Categories categorie = categoryServices.viewcbyid(categoryId);

		if (categorie == null)
			return null;

		p.setCategory(categorie);

		Products sp = prepo.save(p);
		return sp ;

	}

}
