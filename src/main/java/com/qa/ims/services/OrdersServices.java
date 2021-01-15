package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

public class OrdersServices implements CrudServices<Orders> {

	private Dao<Orders> ordersDao;
	
	public OrdersServices(Dao<Orders> ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public List<Orders> readAll() {
		return ordersDao.readAll();
	}
	
	public Orders create(Orders order) {
		return ordersDao.create(order);
	}
	
	public Orders update(Orders order ) {
		return ordersDao.update(order);
	}
	
	public void delete(Long ID) {
		ordersDao.delete(ID);;
	}

}
