package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;

public class OrdersDaoMysql implements Dao<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrdersDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrdersDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orders ordersFromResultSet(ResultSet resultSet) throws SQLException {
		Long Order_ID = resultSet.getLong("Order ID");
		Long Customer_ID = resultSet.getLong("Customer ID");
		String Order_Date = resultSet.getString("Order Date");
		String Order_Address = resultSet.getString("Order Address");
		return new Orders(Order_ID, Customer_ID, Order_Date, Order_Address);
	}

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
			ArrayList<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(ordersFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM orders ORDER BY Order ID DESC LIMIT 1");) {
			resultSet.next();
			return ordersFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(Order ID, Customer ID, Order Date, Order Address) values('"
					+ order.getOrder_ID() + "','" + order.getCustomer_ID() + "','" + order.getOrder_date() + "','"
					+ order.getOrder_address() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readOrders(Long Order_ID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM orders where order ID = " + Order_ID);) {
			resultSet.next();
			return ordersFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set Customer ID ='" + order.getCustomer_ID() + "', Order Date ='"
					+ order.getOrder_date() + "' where order ID =" + order.getOrder_ID());
			return readOrders(order.getOrder_ID());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long orders_ID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers where orders_ID = " + orders_ID);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
