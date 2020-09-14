package com.library.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;
import com.library.dao.UserDao;
import com.library.model.Book;
import com.library.model.User;
import com.library.servlet.RouteURL;

@WebServlet("/users")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = new UserDao().getAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher(RouteURL.LIST_USER_JSP.toString()).forward(request, response);
	}

}
