package com.pizzaria.api.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super("Nenhum registro encontrado");
	}
	
}
