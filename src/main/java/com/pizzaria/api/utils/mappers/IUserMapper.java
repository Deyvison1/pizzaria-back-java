package com.pizzaria.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper extends BaseEntityMapper<User, UserDTO> {
}
