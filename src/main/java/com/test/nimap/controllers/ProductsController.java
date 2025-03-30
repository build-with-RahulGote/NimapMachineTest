package com.test.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public products getProductById(@PathVariable int id) {
		products p1=pservice.viewpbyid(id);
		if(p1!=null)
		{
			return p1;
		}
		else
		{
			throw new RuntimeException("Product Not Found");
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<products>updateProducts(@PathVariable int id,@RequestBody products prod)
	{
		products updateproduct=pservice.updateproduct(id, prod);
		return ResponseEntity.ok(updateproduct);
		
	}
	
	
	@DeleteMapping("/{cid}")
	public String DelProdById(@PathVariable int cid) {

		boolean b = pservice.DelProdById(cid);
		if (b) {
			return "Record \t" + cid + "\tdeleted Successfully.";
		} else {
			return "Some Problem is there...";
		}
	}

}
