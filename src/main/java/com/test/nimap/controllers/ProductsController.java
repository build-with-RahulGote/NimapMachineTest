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

import com.test.nimap.models.Products;
import com.test.nimap.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	@Autowired
	ProductServices pservice;

	//Find All Products with Pagination
	@GetMapping
	public ResponseEntity<Page<Products>> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Page<Products> getallproducts = pservice.getAllProducts(page, size);
		return ResponseEntity.ok(getallproducts);

	}

	//Add New Product
	@PostMapping
	public Products Addproduct(@RequestBody Products product) {

		
		return pservice.savepro(product);
	}

	
	//Find Product By id
	@GetMapping("/{id}")
	public Products getProductById(@PathVariable int id) {
		Products p1 = pservice.viewpbyid(id);
		if (p1 != null) {
			return p1;
		} else {
			throw new RuntimeException("Product Not Found");
		}
	}

	//Update Product By id
	@PutMapping("/{id}")
	public Products updateProducts(@PathVariable int id, @RequestBody Products prod) {
		return pservice.updateproduct(id, prod);

	}

	//Delete product By id
	@DeleteMapping("/{id}")
	public String DelProdById(@PathVariable int id) {

		boolean b = pservice.DelProdById(id);
		if (b) {
			return "Record \t" + id + "\tdeleted Successfully.";
		} else {
			return "Some Problem is there...";
		}
	}

}
