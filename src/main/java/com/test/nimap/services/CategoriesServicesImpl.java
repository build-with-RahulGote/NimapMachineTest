package com.test.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.nimap.models.categories;
import com.test.nimap.repository.CategoryRepository;

@Service
public class CategoriesServicesImpl implements CategoryServices {

	@Autowired
	private CategoryRepository catrepo;

	// Find All Categories with pagination
	@Override
	// provide page number and page size
	public Page<categories> getAllCategories(int offset, int pagesize) {

		Page<categories> getallcategories = catrepo.findAll(PageRequest.of(offset, pagesize));
		return getallcategories;
	}

	// get categories by id
	@Override
	public categories viewcbyid(int id) {

		return catrepo.findById(id).orElseThrow(() -> new RuntimeException(" categories not found with ID: " + id));// Runtime
																													// Exception
																													// in
																													// id
																													// not
																													// found
	}

	// Add new category
	@Override
	public boolean saveCat(categories cat) {
		categories cat1 = catrepo.save(cat);

		return cat1 != null;
	}

	// Delete category by id
	@Override
	public boolean delcatbyid(int id) {
		Optional<categories> cr = catrepo.findById(id);
		if (cr.isPresent()) {
			catrepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	// update category by id
	@Override
	public boolean updateCategory(int id, categories updatedCategory) {
		Optional<categories> opcat = catrepo.findById(id);
		if (opcat.isPresent()) {
			categories cat = opcat.get();
			cat.setCname(updatedCategory.getCname());
			catrepo.save(cat);
			return true;
		}

		return false;
	}

}
