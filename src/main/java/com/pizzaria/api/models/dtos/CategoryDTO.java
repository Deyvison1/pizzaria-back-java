package com.pizzaria.api.models.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
