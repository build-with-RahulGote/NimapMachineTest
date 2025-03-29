package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nimap.models.categories;

public interface CategoryRepository extends JpaRepository<categories, Integer> {

}
