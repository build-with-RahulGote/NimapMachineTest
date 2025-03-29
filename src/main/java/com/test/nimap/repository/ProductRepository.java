package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nimap.models.products;

public interface ProductRepository extends JpaRepository<products, Integer>{

}
