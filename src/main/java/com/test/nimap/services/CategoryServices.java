package com.test.nimap.services;

import org.springframework.data.domain.Page;

import com.test.nimap.models.categories;

//interface for category service 
public interface CategoryServices {

	Page<categories> getAllCategories(int offset, int pagesize);

	boolean saveCat(categories cat);

	categories viewcbyid(int id);

	boolean updateCategory(int id, categories updatedCategory);

	boolean delcatbyid(int id);

}
