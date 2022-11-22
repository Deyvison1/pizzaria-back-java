package com.pizzaria.api.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.pizzaria.api.models.Product;
import com.pizzaria.api.models.dtos.ProductDTO;

@Mapper(componentModel = "spring")
public interface IProductMapper {

	List<Product> toModelList(List<ProductDTO> dtos);
	
	ProductDTO toDTO(Product user);

	List<ProductDTO> toODTOList(List<Product> models);
	
}
