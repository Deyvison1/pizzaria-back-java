package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.api.models.Order;
import com.pizzaria.api.models.dtos.OrderDTO;
import com.pizzaria.api.services.IOrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

	private IOrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderDTO> add(@RequestBody Order order) {
		return ResponseEntity.ok(orderService.add(order));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		return ResponseEntity.ok(orderService.findAll());
	}
	
}
