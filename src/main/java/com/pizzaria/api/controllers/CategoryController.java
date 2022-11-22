package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.api.models.Category;
import com.pizzaria.api.models.dtos.CategoryDTO;
import com.pizzaria.api.services.ICategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
	
	private ICategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDTO> add(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.add(category));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
}
