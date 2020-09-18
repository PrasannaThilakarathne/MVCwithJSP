package com.prasanna.foodcart;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FoodCartDBUtill {

	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://127.0.0.1:3306/food?useSSL=false";
		
		
		String username = "root";
		String password = "1234";

		ArrayList<Food> foodlist = new ArrayList<>();

		// load the driver
		Class.forName("com.mysql.jdbc.Driver");
		// get connection
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		// create statement
		Statement statement = (Statement) con.createStatement();
		// execute the statement and loop over result set
		ResultSet resultSet = statement.executeQuery("select * from foodcart");

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String item = resultSet.getString(2);
			String price = resultSet.getString(3);
			Food food = new Food(id, item, price);
			foodlist.add(food);

		}

		return foodlist;

	}

}
