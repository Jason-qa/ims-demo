package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);

	private CrudServices<Orders> ordersService;

	public OrdersController(CrudServices<Orders> ordersService) {
		this.ordersService = ordersService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersService.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter a Order Date");
		String Order_Date = getInput();
		LOGGER.info("Please enter a Order Address");
		String Order_Address = getInput();
		Orders order = ordersService.create(new Orders(Order_Date, Order_Address));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the Order ID of the Order you would like to update");
		Long Order_ID = Long.valueOf(getInput());
		LOGGER.info("Please enter a Order Date");
		String Order_Date = getInput();
		LOGGER.info("Please enter a Order Address");
		String Order_Address = getInput();
		Orders order = ordersService.create(new Orders(Order_ID, Order_Date, Order_Address));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the Order ID of the Order you would like to delete");
		Long Order_ID = Long.valueOf(getInput()); 
		ordersService.delete(Order_ID);
	}

}
