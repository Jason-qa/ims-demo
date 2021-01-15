package com.qa.ims.persistence.domain;

public class Item {

	private Long item_ID;
	private String item_name;
	private double price;

	public Item(String item_name, double price) {
		super();
		this.item_name = item_name;
		this.price = price;
	}

	public Item(Long item_ID, String item_name, double price) {
		super();
		this.item_ID = item_ID;
		this.item_name = item_name;
		this.price = price;
	}

	public Long getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(Long item_ID) {
		this.item_ID = item_ID;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "ITEM_ID: " + item_ID + " ITEM_NAME: " + item_name + " PRICE: " + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_ID == null) ? 0 : item_ID.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		if (item_ID == null) {
			if (other.item_ID != null)
				return false;
		} else if (!item_ID.equals(other.item_ID))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;

		return true;
	}

}
