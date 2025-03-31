package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.nimap.models.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
