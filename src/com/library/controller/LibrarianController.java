package com.library.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.BookService;
import com.library.service.LibrarianServise;

/**
 * Servlet implementation class LibrarianController
 */
@WebServlet("/librarian/*")
public class LibrarianController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LibrarianServise librarianservise;

	@Override
	public void init() throws ServletException {
		super.init();
		this.librarianservise = new LibrarianServise();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String arr[] = request.getRequestURI().split("/");
		System.out.println("current url is : " + request.getRequestURI());
		
//		
//		String action = arr[arr.length - 1];
//		switch (action) {
//		case "add":
//			String firstName = request.getParameter("firstname");
//			String lastName = request.getParameter("lastname");
//			String email = request.getParameter("email");
//			String password = request.getParameter("password");
//
//			librarianservise.addLibrarian(firstName, lastName, email, password)				
//		
//			break;
//		default:
			RequestDispatcher dis =  request.getRequestDispatcher("user-list.jsp");
			dis.forward(request, response);
//			throw new IllegalArgumentException("Unexpected value: " + action);
//		}

	}

}
