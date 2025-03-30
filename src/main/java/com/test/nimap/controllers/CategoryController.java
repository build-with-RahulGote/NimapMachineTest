package com.test.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
