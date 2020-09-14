package com.library.servlet.user;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/update-user")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Optional<User> user = new UserDao().get(id);
		if (user.isPresent()) {
			request.setAttribute("user", user.get());
			request.getRequestDispatcher(RouteURL.UPDATE_USER_JSP.toString()).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User user = User.builder().id(id).userName(username).password(password).role(role).build();
		new UserDao().update(user);
		response.sendRedirect(RouteURL.LIST_USER.toString());
	}

}
