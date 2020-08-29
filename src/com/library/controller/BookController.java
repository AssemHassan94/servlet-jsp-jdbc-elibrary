package com.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.BookService;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/book/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookService bookService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.bookService = new BookService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String arr[] = request.getRequestURI().split("/");
		System.out.println("current url is : " + request.getRequestURI());
		if (arr.length != 4) {
			return;
		}
		
		
		String action = arr[arr.length - 1];
		switch (action) {
		case "add": 
			String title = request.getParameter("bookTitle");
			String author= request.getParameter("authorName");
			bookService.addNewBook(title, author);
			break;
		case "delete": 

			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

}
