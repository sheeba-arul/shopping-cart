/**
 * 
 */
package com.shopping.cart.tdd;

import java.math.BigDecimal;

/**
 * @author Sheeba Arulmariadoss
 *
 */
public class ShoppingCart {

	int totalNoOfItems =0;
	BigDecimal totalPrice=new BigDecimal("0");
	
	public void addItem(Item item, int i) {
		// TODO Auto-generated method stub
		
		totalNoOfItems += i;
		totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(i)));
		
	}

	public int getTotalNoOfItems() {
		// TODO Auto-generated method stub
		return totalNoOfItems;
	}

	public void setTotalNoOfItems(int itemsBought)
	{
		this.totalNoOfItems = itemsBought;
	}

	public BigDecimal getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		totalPrice= price;
	}
}
