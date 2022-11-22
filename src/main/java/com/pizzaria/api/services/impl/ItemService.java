package com.pizzaria.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizzaria.api.exceptions.NotFoundException;
import com.pizzaria.api.models.Item;
import com.pizzaria.api.models.dtos.ItemDTO;
import com.pizzaria.api.models.repository.IItemRepository;
import com.pizzaria.api.services.IItemService;
import com.pizzaria.api.utils.mappers.IItemMapper;

@Service
public class ItemService implements IItemService {

	private IItemRepository itemRepo;
	private IItemMapper itemMapper;
	
	public ItemService(IItemRepository itemRepo, IItemMapper itemMapper) {
		this.itemRepo = itemRepo;
		this.itemMapper = itemMapper;
	}
	
	@Override
	public ItemDTO add(Item item) {
		return itemMapper.toDTO(itemRepo.save(item));
	}

	@Override
	public void remove(ItemDTO item) {	
		itemRepo.delete(itemMapper.toModel(item));
	}

	@Override
	public List<ItemDTO> findByOrder(Long orderId) {	
		Optional<List<Item>> itens = itemRepo.findByTableOrderId(orderId);
		return itemMapper.toDTOList(itens.orElseThrow( () -> new NotFoundException()));
	}

}
