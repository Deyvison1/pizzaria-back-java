package com.pizzaria.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaria.api.models.Category;
import com.pizzaria.api.models.dtos.CategoryDTO;
import com.pizzaria.api.models.repository.ICategoryRepository;
import com.pizzaria.api.services.ICategoryService;
import com.pizzaria.api.utils.mappers.ICategoryMapper;

@Service
public class CategoryService implements ICategoryService {
	
	private ICategoryRepository categoryRepo;
	private ICategoryMapper categoryMapper;
	
	public CategoryService(ICategoryRepository categoryRepo, ICategoryMapper categoryMapper) {
		this.categoryRepo = categoryRepo;
		this.categoryMapper = categoryMapper;
	}
	
	@Override
	public CategoryDTO add(Category category) {
		return categoryMapper.toDTO(categoryRepo.save(category));
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryMapper.toDTOList(categoryRepo.findAll());
	}
}
