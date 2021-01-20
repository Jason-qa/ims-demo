package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Orders {

	private Long Order_ID;
	private Long Customer_ID;
	private ArrayList<Items> Items;

	public Orders(Long order_ID, Long customer_ID, ArrayList<Items> items) {
		this.Order_ID = order_ID;
		this.Customer_ID = customer_ID;
		this.Items = items;
	}

	public Orders(Long order_ID, Long customer_ID) {
		this.Order_ID = order_ID;
		this.Customer_ID = customer_ID;
	}

	public Orders(Long customer_ID) {
		Customer_ID = customer_ID;
	}

	public Long getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(Long order_ID) {
		Order_ID = order_ID;
	}

	public Long getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(Long customer_ID) {
		Customer_ID = customer_ID;
	}

	public ArrayList<Items> getItems() {
		return Items;
	}

	public void setItems(ArrayList<Items> items) {
		Items = items;
	}

	@Override
	public String toString() {
		return "Order_ID: " + Order_ID + ", Customer_ID: " + Customer_ID + ", Items: " + Items;
	}

} 


