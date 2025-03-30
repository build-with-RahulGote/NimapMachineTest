package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.nimap.models.products;
@Repository
public interface ProductRepository extends JpaRepository<products, Integer>{
	
	
	

}
