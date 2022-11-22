package com.pizzaria.api.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.pizzaria.api.models.Category;
import com.pizzaria.api.models.dtos.CategoryDTO;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

	List<Category> toModelList(List<CategoryDTO> dtos);
	
	CategoryDTO toDTO(Category model);

	List<CategoryDTO> toDTOList(List<Category> models);
}
