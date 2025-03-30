package com.test.nimap.services;

import org.springframework.data.domain.Page;

import com.test.nimap.models.categories;



public interface CategoryServices {
	
	 Page<categories> getAllCategories(int offset,int pagesize);
	 categories viewpbyid(int id);

}
