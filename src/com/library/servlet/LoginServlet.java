package com.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.service.AuthenticationService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthenticationService authenticationService;

	public LoginServlet() {
		super();
		authenticationService = AuthenticationService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String userValidate = authenticationService.isAuthenticated(email, password);
		if (userValidate.equals("Admin_Role")) {
			Cookie cookie = authenticationService.addSession(request, email);
			response.addCookie(cookie);

			RequestDispatcher reqd = request.getRequestDispatcher("jsp/homeAdmin.jsp");
			reqd.forward(request, response);

		} else if (userValidate.equals("Librarian_Role")) {
			Cookie cookie = authenticationService.addSession(request, email);
			response.addCookie(cookie);

			RequestDispatcher reqd = request.getRequestDispatcher("jsp/homeLibrarian.jsp");
			reqd.forward(request, response);

		} else if (userValidate.equals("User_Role")) {
			Cookie cookie = authenticationService.addSession(request, email);
			response.addCookie(cookie);

			RequestDispatcher reqd = request.getRequestDispatcher("jsp/main.jsp");
			reqd.forward(request, response);

		} else {
			System.out.println("Error message = " + userValidate);
			request.setAttribute("errMessage", userValidate);

			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

}
