package com.pizzaria.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pizzaria.api.models.Item;
import com.pizzaria.api.models.dtos.ItemDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IItemMapper extends BaseEntityMapper<Item, ItemDTO> {
}
