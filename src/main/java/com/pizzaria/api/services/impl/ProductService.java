package com.pizzaria.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaria.api.models.Product;
import com.pizzaria.api.models.dtos.ProductDTO;
import com.pizzaria.api.models.repository.IProductRepository;
import com.pizzaria.api.services.IProductService;
import com.pizzaria.api.utils.mappers.IProductMapper;

@Service
public class ProductService implements IProductService {

	private IProductRepository productRepository;
	private IProductMapper productMapper;
	
	public ProductService(IProductRepository productRepository, IProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}
	
	@Override
	public ProductDTO add(Product product) {
		return productMapper.toDto(productRepository.save(product));
	}
	@Override
	public List<ProductDTO> findAll() {
		return productMapper.toDto(productRepository.findAll());
	}
	
	
}
