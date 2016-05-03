package com.shopping.cart.tdd;

import java.math.BigDecimal;

public class Item {
	
	private ItemType name;
	private BigDecimal price;
	
	
	public Item(ItemType apple, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
		setName(apple);
		setPrice(bigDecimal);
	}
	
	
	public ItemType getName() {
		return name;
	}
	public void setName(ItemType name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
