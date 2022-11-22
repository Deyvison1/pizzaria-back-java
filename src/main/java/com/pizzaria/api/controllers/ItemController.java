package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.api.models.Item;
import com.pizzaria.api.models.dtos.ItemDTO;
import com.pizzaria.api.services.IItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

	private IItemService itemService;
	
	@PostMapping
	public ResponseEntity<ItemDTO> add(@RequestBody Item item) {
		return ResponseEntity.ok(itemService.add(item));
	}
	
	@DeleteMapping
	public void remove(@RequestBody ItemDTO item) {
		itemService.remove(item);
	}
	
	@GetMapping("/findByOrder/{orderId}")
	public ResponseEntity<List<ItemDTO>> findByOrder(@PathVariable Long orderId) {
		return ResponseEntity.ok(itemService.findByOrder(orderId));
	}
	
}
