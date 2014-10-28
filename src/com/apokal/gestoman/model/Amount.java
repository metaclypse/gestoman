package com.apokal.gestoman.model;

public class Amount {
	public static final int UNIT_GRAM 			= 0;
	public static final int UNIT_KILOGRAM 		= 1;
	public static final int UNIT_LITER 			= 2;
	public static final int CUBIC_CENTIMETER 	= 3;
	
	public int unit;
	public float amount;
	
	public Amount (float amount, int unit) {
		this.unit = unit;
		this.amount = amount;
	}
}
