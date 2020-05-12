package com.wpcursos.course.entities.enums;

public enum OrderStatus {

// Java define um numero para cada enum, comecando por 0, 1, 2, ...
	// No caso de incluir mais um enum vai gerar problema no banco com a numeracao
	// do status

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	private OrderStatus(int code) {

		this.code = code;
	}

	public int getcode() {

		return code;
	}

	// Verifica e localiza o c'odigo do status retornando o status
	
	public static OrderStatus valueOf(int code) {

		for (OrderStatus value : OrderStatus.values()) {

			if (value.getcode() == code) {

				return value;
			}
		}

		throw new IllegalArgumentException("Invalid OrderStatus code !!!");

	}

}
