package com.pizzaria.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pizzaria.api.models.Product;
import com.pizzaria.api.models.dtos.ProductDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper extends BaseEntityMapper<Product, ProductDTO> {
	
}
