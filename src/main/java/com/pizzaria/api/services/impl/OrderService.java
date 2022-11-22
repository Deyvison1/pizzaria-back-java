package com.pizzaria.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.dtos.OrderDTO;
import com.pizzaria.api.models.repository.IOrderRepository;
import com.pizzaria.api.services.IOrderService;
import com.pizzaria.api.utils.mappers.IOrderMapper;

@Service
public class OrderService implements IOrderService {
	
	private IOrderRepository orderRepo;
	private IOrderMapper orderMapper;
	
	public OrderService(IOrderRepository orderRepo, IOrderMapper orderMapper) {
		this.orderMapper = orderMapper;
		this.orderRepo = orderRepo;
	}
	
	public OrderDTO add(Order order) {
		return orderMapper.toDTO(orderRepo.save(order));
	}
	
	public List<OrderDTO> findAll() {
		return orderMapper.toDTOList(orderRepo.findAll());
	}
	
	
}
