package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);

	private CrudServices<Items> itemService;

	public ItemsController(CrudServices<Items> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Items> readAll() {
		List<Items> items = itemService.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter the item name");
		String Name = getInput();
		LOGGER.info("Please enter a price");
		String Price = getInput();
		Items item = itemService.create(new Items(Name, Double.parseDouble(Price)));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the ID of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a item name");
		String Name = getInput();
		LOGGER.info("Please enter a price");
		String price = getInput();
		Items item = itemService.update(new Items(id, Name, Double.parseDouble(price)));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
	}

}
