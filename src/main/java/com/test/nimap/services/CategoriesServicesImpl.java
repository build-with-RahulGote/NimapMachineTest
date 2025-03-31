package com.test.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.nimap.models.Categories;
import com.test.nimap.repository.CategoryRepository;

@Service
public class CategoriesServicesImpl implements CategoryServices{
	
	@Autowired
	private CategoryRepository catrepo; 

   //Find All Categories with pagination
	@Override
	//provide page number and page size
	public Page<Categories> getAllCategories(int offset, int pagesize) { 
		
		Page<Categories>getallcategories=catrepo.findAll(PageRequest.of(offset, pagesize));
		return getallcategories;
	}

	

	//get categories by id
	@Override
	public Categories viewcbyid(int id) {
		
		return catrepo.findById(id).orElseThrow(() -> new RuntimeException(" categories not found with ID: " + id));//Runtime Exception in id not found
	}

	

	//Add new category
	@Override
	public boolean saveCat(Categories cat) {
		Categories cat1=catrepo.save(cat);
		
		return cat1!=null;
	}


	//Delete category by id
	@Override
	public boolean delcatbyid(int id) {
		Optional<Categories>cr=catrepo.findById(id);
		if(cr.isPresent())
		{
			catrepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	

	//update category by id
	@Override
	public boolean updateCategory(int id, Categories updatedCategory) {
		Optional<Categories>opcat=catrepo.findById(id);
		if(opcat.isPresent())
		{
			Categories cat=opcat.get();
			cat.setCname(updatedCategory.getCname());
			catrepo.save(cat);
			return true;
		}
	
		return false;
	}


	

}
