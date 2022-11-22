package com.pizzaria.api.services;

import java.util.List;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.dtos.OrderDTO;

public interface IOrderService {

	OrderDTO add(Order order);
	
	List<OrderDTO> findAll();
}
