/**
 * 
 */
package com.shopping.cart.tdd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sheeba Arulmariadoss
 *
 */
public class ShoppingCart {

	private int totalNoOfItems = 0;
	private BigDecimal totalPrice = new BigDecimal("0");
	private List<Item> itemList = new ArrayList<Item>();
	private ConcurrentHashMap<ItemType, Integer> checkoutItem = new ConcurrentHashMap<ItemType, Integer>();
	private BigDecimal discountPrice = new BigDecimal(0);

	public void addItem(Item item, int i) {
		// TODO Auto-generated method stub
		totalNoOfItems += i;

		totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(i)));

		itemList.add(item);
		// instead of iterating list
		if (checkoutItem.containsKey(item.getName())) {
			int noOfItems = checkoutItem.get(item.getName());
			checkoutItem.put(item.getName(), ++noOfItems);
		} else {
			checkoutItem.put(item.getName(), i);
		}

	}

	public int getTotalNoOfItems() {
		// TODO Auto-generated method stub
		return totalNoOfItems;
	}

	public void setTotalNoOfItems(int itemsBought) {
		this.totalNoOfItems = itemsBought;
	}

	public BigDecimal getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		totalPrice = price;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void checkout() {
		// TODO Auto-generated method 
		totalPrice = totalPrice.subtract(discountPrice);
	}

	public void setBuyOneGetOneOffer(ItemType itemType, OfferType offerType, BigDecimal price) {
		// TODO Auto-generated method stub
		if (ItemType.APPLE == itemType && offerType == OfferType.BUY_ONE_GET_ONE_FREE) {
			int noOfItems = checkoutItem.get(itemType);
			// for every one item remaining add one item
			if (noOfItems % 2 == 1) {
				++noOfItems;
				++totalNoOfItems;
				totalPrice = totalPrice.add(price);
			}
			discountPrice = discountPrice.add(new BigDecimal(noOfItems / 2).multiply(price));
		}
	}

	public void setBuyThreeForTwoOffer(ItemType itemType, OfferType offerType, BigDecimal price) {
		// TODO Auto-generated method 
		if (ItemType.ORANGE == itemType && offerType == OfferType.BUY_THREE_PAY_FOR_TWO) {
			int noOfItems = checkoutItem.get(itemType);
			// group items in 3's, for every group 1 is free,
			// do not do anything with the remaining items
			noOfItems = noOfItems - (noOfItems % 3);
			discountPrice = discountPrice.add(new BigDecimal(noOfItems / 3).multiply(price));

		}
	}
}
