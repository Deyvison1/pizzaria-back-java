package com.pizzaria.api.services;

import java.util.List;

import com.pizzaria.api.models.Category;
import com.pizzaria.api.models.dtos.CategoryDTO;

public interface ICategoryService {

	CategoryDTO add(Category category);
	
	List<CategoryDTO> findAll();
}
