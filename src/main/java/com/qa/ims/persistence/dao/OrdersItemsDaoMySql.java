package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders_Items;

public class OrdersItemsDaoMySql implements Dao<Orders_Items> {

	public static final Logger LOGGER = Logger.getLogger(OrdersItemsDaoMySql.class);
	
	private String jdbcConnectionUrl;
	private String username;
	private String password;
	
	public OrdersItemsDaoMySql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	public OrdersItemsDaoMySql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	Orders_Items ordersItemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long OrdersItems_ID = resultSet.getLong("orders_items ID");
		String Name = resultSet.getString("name"); 
		String price = resultSet.getString("price");
		int price1 = Integer.parseInt(price);
		return new Orders_Items(OrdersItems_ID, Name, price1);
	} 
	
	@Override
	public List<Orders_Items> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders_items");) {
			ArrayList<Orders_Items> ordersItems = new ArrayList<>();
			while (resultSet.next()) {
				ordersItems.add(ordersItemsFromResultSet(resultSet));
			}
			return ordersItems;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Orders_Items readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM orders_items ORDER BY orders_items ID DESC LIMIT 1");) {
			resultSet.next();
			return ordersItemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders_Items create(Orders_Items orders_items) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders_items(name, quantity) values('" + orders_items.getItem_name()
					+ "','" + orders_items.getQuantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders_Items readOrdersItems(Long OrdersItemsID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM orders_items where orders items ID = " + OrdersItemsID);) {
			resultSet.next();
			return ordersItemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace()); 
			LOGGER.error(e.getMessage());
		}
		return null; 
	}
	
	@Override
	public Orders_Items update(Orders_Items orders_items) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders_items quantity ='" + orders_items.getQuantity() + "' where orders_items ID =" + orders_items.getOrder_ID());
			return readOrdersItems(orders_items.getOrder_ID());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public void delete(long OrdersItemsID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orders_items where orders_items ID = " + 	OrdersItemsID);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
}
