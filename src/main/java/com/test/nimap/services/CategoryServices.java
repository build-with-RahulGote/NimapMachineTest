package com.test.nimap.services;

import org.springframework.data.domain.Page;

import com.test.nimap.models.Categories;


//interface for category service 
public interface CategoryServices {
	
	 Page<Categories> getAllCategories(int offset,int pagesize);
     boolean saveCat(Categories cat);
	 Categories viewcbyid(int id);
	 boolean updateCategory(int id, Categories updatedCategory);
	 boolean delcatbyid(int id);


}
