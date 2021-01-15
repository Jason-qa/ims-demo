package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders_Items;

public class Orders_ItemsServices implements CrudServices<Orders_Items> {

	private Dao<Orders_Items> orders_itemsDao;
	
	public Orders_ItemsServices(Dao<Orders_Items> orders_itemsDao) {
		this.orders_itemsDao = orders_itemsDao;
	}
	
	public List<Orders_Items> readAll() {
		return orders_itemsDao.readAll();
	}
	
	public Orders_Items create(Orders_Items orders_items) {
		return orders_itemsDao.create(orders_items);
	}
	
	public Orders_Items update(Orders_Items orders_items) {
		return orders_itemsDao.update(orders_items);
	}
	
	public void delete(Long id) {
		orders_itemsDao.delete(id); 
	}
}
