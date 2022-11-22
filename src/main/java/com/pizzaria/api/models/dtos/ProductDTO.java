package com.pizzaria.api.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pizzaria.api.models.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private BigDecimal price;
	private String description;
	private String banner;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Category category;
}
