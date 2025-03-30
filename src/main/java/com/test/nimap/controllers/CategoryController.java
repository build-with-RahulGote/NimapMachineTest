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

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	public CategoryServices catservice;
	
	@GetMapping
	public ResponseEntity<Page<categories>>getAllCategories(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size)
	{
		Page<categories>getcat=catservice.getAllCategories(page, size);
		return ResponseEntity.ok(getcat);
		
	}
	
	@PostMapping
	public String AddCategory(@RequestBody categories c) {
			
		boolean b =catservice.saveCat(c);
		if(b) {
			return "Category Added Successfully";
		}
		else {
			return "some problem is there.....";
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<categories>getProductById(@PathVariable int id) {
		categories c1=catservice.viewpbyid(id);
		return ResponseEntity.ok(c1);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String>updateCatgoery(@PathVariable int id,@RequestBody categories updatecat)
	{
		boolean update=catservice.updateCategory(id, updatecat);
		if(update)
		{
			return ResponseEntity.ok("Category updated successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("Category not found");
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	public String delbyid(@PathVariable int id) {
		boolean b = catservice.delcatbyid(id);
		if (b) {
			return "Record deleted";
		} else {
			return "Record not found";
		}
		
		

}
}
