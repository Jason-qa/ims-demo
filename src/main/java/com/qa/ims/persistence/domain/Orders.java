package com.qa.ims.persistence.domain;

public class Orders {

	private Long order_ID;
	private Long customer_ID;
	private String order_date;
	private String order_address;

	public Orders(Long order_ID, Long customer_ID, String order_date, String order_address) {

		this.order_ID = order_ID;
		this.customer_ID = customer_ID;
		this.order_date = order_date;
		this.order_address = order_address;
	}

	public Orders(String order_date, String order_address) {
		this.order_date = order_date;
		this.order_address = order_address;
	}

	
	public Orders(Long order_ID, String order_date, String order_address) {
		super();
		this.order_ID = order_ID;
		this.order_date = order_date;
		this.order_address = order_address;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public Long getOrder_ID() {
		return order_ID;
	}

	public Long getCustomer_ID() {
		return customer_ID;
	}

}
