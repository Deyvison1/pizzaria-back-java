package com.pizzaria.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pizzaria.api.models.Category;
import com.pizzaria.api.models.dtos.CategoryDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper extends BaseEntityMapper<Category, CategoryDTO> {
}
