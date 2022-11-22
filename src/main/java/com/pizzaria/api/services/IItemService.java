package com.pizzaria.api.services;

import java.util.List;

import com.pizzaria.api.models.Item;
import com.pizzaria.api.models.dtos.ItemDTO;

public interface IItemService {

	ItemDTO add(Item item);
	
	void remove(ItemDTO item);
	
	List<ItemDTO> findByOrder(Long orderId);
}
