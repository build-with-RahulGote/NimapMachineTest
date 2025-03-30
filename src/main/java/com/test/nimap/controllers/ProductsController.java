package com.test.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.nimap.models.products;
import com.test.nimap.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	@Autowired
	ProductServices pservice;
	
	@GetMapping
	public ResponseEntity<Page<products>>getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size)
	{
		Page<products>getallproducts=pservice.getAllProducts(page, size);
		return ResponseEntity.ok(getallproducts);
		
	}

}
