package com.pizzaria.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.dtos.OrderDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper extends BaseEntityMapper<Order, OrderDTO> {
	
}
