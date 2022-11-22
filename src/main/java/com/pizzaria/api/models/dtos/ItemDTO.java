package com.pizzaria.api.models.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private int amount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Order tableOrder;
	private Product product;
	
}
