package com.pizzaria.api.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.pizzaria.api.models.Item;
import com.pizzaria.api.models.dtos.ItemDTO;

@Mapper(componentModel = "spring")
public interface IItemMapper {
	List<Item> toModelList(List<ItemDTO> dtos);
	
	ItemDTO toDTO(Item model);
	Item toModel(ItemDTO dtto);

	List<ItemDTO> toDTOList(List<Item> models);
}
