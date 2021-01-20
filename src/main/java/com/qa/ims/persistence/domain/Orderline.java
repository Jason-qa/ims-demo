package com.qa.ims.persistence.domain;

public class Orderline {

	private Long Orderline_ID;
	private Long Order_ID;
	private Long Item_Id;

	Orderline(Long orderline_ID, Long order_Id, Long item_Id) {
		this.Orderline_ID = orderline_ID;
		this.Order_ID = order_Id;
		this.Item_Id = item_Id;
	}

	public Long getOrderline_ID() {
		return Orderline_ID;
	}

	public void setOrderline_ID(Long orderline_ID) {
		Orderline_ID = orderline_ID;
	}

	public Long getOrder_Id() {
		return Order_ID;
	}

	public void setOrder_Id(Long order_Id) {
		Order_ID = order_Id;
	}

	public Long getItem_Id() {
		return Item_Id; 
	}

	public void setItem_Id(Long item_Id) {
		Item_Id = item_Id;
	}

	@Override
	public String toString() {
		return "Orderline_ID: " + Orderline_ID + ", Order_Id=" + Order_ID + ", Item_Id=" + Item_Id + "]";
	}
	
	

}
