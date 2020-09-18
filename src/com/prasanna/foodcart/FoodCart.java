package com.prasanna.foodcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the data from db(model)
		try {
			List<Food> fooditems = FoodCartDBUtill.getFoodList();
			request.setAttribute("fooditems", fooditems);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String [] fooditems = {"briyani", "pizza"};
		// request.setAttribute("fooditems", fooditems);

		// redirect to a different page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("Show-Food.jsp");
		dispatcher.forward(request, response);
	}

}
