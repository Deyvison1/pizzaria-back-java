package com.pizzaria.api.exceptions;

public class PasswordInvalidException extends RuntimeException {
	public PasswordInvalidException() {
		super("Senha invalida!");
	}
}
