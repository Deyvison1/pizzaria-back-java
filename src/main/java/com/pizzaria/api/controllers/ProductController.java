package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.api.models.Product;
import com.pizzaria.api.models.dtos.ProductDTO;
import com.pizzaria.api.services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	private IProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDTO> add(@RequestBody Product product) {
		return ResponseEntity.ok(productService.add(product));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		return ResponseEntity.ok(productService.findAll());
	}
	
}
