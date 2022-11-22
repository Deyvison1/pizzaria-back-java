package com.pizzaria.api.services;

import java.util.List;

import com.pizzaria.api.models.Product;
import com.pizzaria.api.models.dtos.ProductDTO;

public interface IProductService {

	ProductDTO add(Product product);
	
	List<ProductDTO> findAll();
}
