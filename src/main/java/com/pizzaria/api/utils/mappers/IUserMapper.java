package com.pizzaria.api.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;

@Mapper(componentModel = "spring")
public interface IUserMapper {
		
		List<User> toModelList(List<UserDTO> dtos);
		
		UserDTO toDTO(User user);

		List<UserDTO> toDTOList(List<User> models);
}
