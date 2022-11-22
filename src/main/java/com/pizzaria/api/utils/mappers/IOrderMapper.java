package com.pizzaria.api.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.dtos.OrderDTO;

@Mapper(componentModel = "spring")
public interface IOrderMapper {

	List<Order> toModelList(List<OrderDTO> dtos);
	
	OrderDTO toDTO(Order model);

	List<OrderDTO> toDTOList(List<Order> models);
	
}
