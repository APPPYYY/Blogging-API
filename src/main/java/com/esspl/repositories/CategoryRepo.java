package com.esspl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.models.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
