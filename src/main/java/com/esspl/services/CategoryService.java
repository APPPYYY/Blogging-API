package com.esspl.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esspl.payloads.CategoryDto;


public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	void deleteCategory(Integer categoryId);
	CategoryDto getByCategoryId(Integer categoryId);
	List<CategoryDto> getAllCategory();
}
