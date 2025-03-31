package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.nimap.models.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	
}
