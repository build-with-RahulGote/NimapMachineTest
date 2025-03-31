package com.test.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.nimap.models.categories;

@Repository
public interface CategoryRepository extends JpaRepository<categories, Integer> {

}
