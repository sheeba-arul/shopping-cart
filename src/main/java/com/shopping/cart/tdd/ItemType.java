package com.shopping.cart.tdd;

public enum ItemType {
	APPLE("Apple"),
	ORANGE("Orange");
	
	private final String name;
	
	ItemType(final String itemName)
	{
		this.name = itemName;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
