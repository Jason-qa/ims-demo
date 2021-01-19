package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders_Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrdersItemsController implements CrudController<Orders_Items> {

	public static final Logger LOGGER = Logger.getLogger(OrdersItemsController.class);

	private CrudServices<Orders_Items> ordersItemsService;

	public OrdersItemsController(CrudServices<Orders_Items> ordersItemsService) {
		this.ordersItemsService = ordersItemsService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orders_Items> readAll() {
		List<Orders_Items> ordersItems = ordersItemsService.readAll();

		for (Orders_Items ordersItem : ordersItems) {
			LOGGER.info(ordersItem.toString());
		}
		return ordersItems;
	}

	@Override
	public Orders_Items create() {
		LOGGER.info("please enter item name");
		String Item_name = getInput();
		LOGGER.info("please enter the quantity");
		String quantity = getInput();
		int quantity1 = Integer.parseInt(quantity);
		Orders_Items ordersItem = ordersItemsService.create(new Orders_Items(Item_name, quantity1));
		LOGGER.info("Order created");
		return ordersItem;
	}

	@Override
	public Orders_Items update() {
		LOGGER.info("Please enter the Order ID of the Orderline you would like to update");
		Long Order_ID = Long.valueOf(getInput());
		LOGGER.info("Please enter the item name");
		String Item = getInput();
		LOGGER.info("Please enter the quantity");
		String quantity = getInput();
		int quantity1 = Integer.parseInt(quantity);
		Orders_Items ordersItem = ordersItemsService.create(new Orders_Items(Order_ID, Item, quantity1));
		LOGGER.info("Order created");
		return ordersItem;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the Orders_Items ID of the Order you would like to delete");
		Long Orders_Items_ID = Long.valueOf(getInput());
		ordersItemsService.delete(Orders_Items_ID);
	}
}