package com.secao22_266.secao22_266.entities.enums;

import java.util.Iterator;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	/*
	 * Agora pra esse código ficar acessível ao mundo exterior, 
	 * eu vou criar o método público para acessar esse código.
	 * 
	 */
	public int getCode() {
		return code;
	}
	
	/*
	 * Agora pessoal eu vou fazer um método estático pra converter um valor numérico, 
	 * para o tipo enumerado, que eventualmente a gente vai precisar também.
	 * 
	 */
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Código de OrderStatus inválido!");
	}

}
