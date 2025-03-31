package com.test.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.nimap.models.categories;
import com.test.nimap.services.CategoryServices;

@RestController // set as Controller
@RequestMapping("/api/categories") // API mapping
public class CategoryController {
	@Autowired
	public CategoryServices catservice;

	// Find All Categories with Pagination
	@GetMapping
	public ResponseEntity<Page<categories>> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<categories> getcat = catservice.getAllCategories(page, size);
		return ResponseEntity.ok(getcat);

	}

	// Add New Category
	@PostMapping
	public String AddCategory(@RequestBody categories c) {

		boolean b = catservice.saveCat(c);
		if (b) {
			return "Category Added Successfully";
		} else {
			return "some problem is there.....";
		}
	}

	// Find Category By Id
	@GetMapping("/{id}")
	public ResponseEntity<categories> getCategoriesById(@PathVariable int id) {
		categories c1 = catservice.viewcbyid(id);
		return ResponseEntity.ok(c1);
	}

	// update Category By id
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCatgoery(@PathVariable int id, @RequestBody categories updatecat) {
		boolean update = catservice.updateCategory(id, updatecat);
		if (update) {
			return ResponseEntity.ok("Category updated successfully");
		} else {
			return ResponseEntity.status(404).body("Category not found");
		}
	}

	// Delete Category By id
	@DeleteMapping(value = "/{id}")
	public String deleteCatById(@PathVariable int id) {
		boolean b = catservice.delcatbyid(id);
		if (b) {
			return "Record deleted";
		} else {
			return "Record not found";
		}

	}
}
