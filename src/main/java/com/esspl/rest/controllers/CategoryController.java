package com.esspl.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.payloads.ApiResponse;
import com.esspl.payloads.CategoryDto;
import com.esspl.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createdCat= this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCat,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer cid){
		CategoryDto updatedCat= this.categoryService.updateCategory(categoryDto, cid);
		return new ResponseEntity<>(updatedCat,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer cid){
		this.categoryService.deleteCategory(cid);
		return new ResponseEntity<>(new ApiResponse("__comeflywithme__","Category successfully deleted !","Sorry ab kuch nehi"
				+ " kar sakte !!!",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> cat=this.categoryService.getAllCategory();
		return ResponseEntity.ok(cat);
		 
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getByCategoryId(@PathVariable("categoryId") Integer cid){
		CategoryDto cat=this.categoryService.getByCategoryId(cid);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
