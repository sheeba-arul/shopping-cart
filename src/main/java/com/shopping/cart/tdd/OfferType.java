package com.shopping.cart.tdd;

public enum OfferType {
	NO_OFFER("No_Offer"),
	BUY_ONE_GET_ONE_FREE("Buy_One_Get_One_Free"),
	BUY_THREE_PAY_FOR_TWO("Buy_Three_Pay_For_two");
	
	private final String name;
	
	OfferType(final String itemName)
	{
		this.name = itemName;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}

