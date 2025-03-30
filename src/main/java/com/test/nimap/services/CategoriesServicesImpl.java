package com.test.nimap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.nimap.models.categories;
import com.test.nimap.repository.CategoryRepository;

@Service
public class CategoriesServicesImpl implements CategoryServices{
	
	@Autowired
	private CategoryRepository catrepo;


	@Override
	public Page<categories> getAllCategories(int offset, int pagesize) {
		
		Page<categories>getallcategories=catrepo.findAll(PageRequest.of(offset, pagesize));
		return getallcategories;
	}

}
