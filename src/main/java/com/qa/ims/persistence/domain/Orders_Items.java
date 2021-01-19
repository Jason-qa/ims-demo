package com.qa.ims.persistence.domain;

public class Orders_Items {

	private Long orders_items_ID;
	private Long item_ID;
	private Long order_ID;
	private int quantity;
	private String item_name;

	public Orders_Items(Long orders_items_ID, Long item_ID, Long order_ID, int quantity, String item_name) {
		this.orders_items_ID = orders_items_ID;
		this.item_ID = item_ID;
		this.order_ID = order_ID;
		this.quantity = quantity;
		this.item_name = item_name;
	}

	public Orders_Items(String item_name, int quantity) {
		this.item_name = item_name;
		this.quantity = quantity;

	}

	public Orders_Items(Long order_ID, String item_name, int quantity) {
		this.order_ID = order_ID;
		this.item_name = item_name;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getOrders_items_ID() {
		return orders_items_ID;
	}

	public Long getItem_ID() {
		return item_ID;
	}

	public Long getOrder_ID() {
		return order_ID;
	}

	public String getItem_name() {
		return item_name;
	}

}
