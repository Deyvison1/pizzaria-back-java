package com.pizzaria.api.controllers.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsDTO {

	private String email;
	private String password;
}
