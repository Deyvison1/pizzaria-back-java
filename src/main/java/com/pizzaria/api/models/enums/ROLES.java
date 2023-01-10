package com.pizzaria.api.models.enums;

public enum ROLES {
	ADMIN("ADMIN"), WAITER("WAITER"), ATTENDANT("ATTENDANT");

	private String value;

	private ROLES(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
