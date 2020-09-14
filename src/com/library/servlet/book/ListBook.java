package com.library.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;
import com.library.model.Book;
import com.library.servlet.RouteURL;

@WebServlet("/books")
public class ListBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Book> books = new BookDao().getAll();
		request.setAttribute("books", books);
		request.getRequestDispatcher(RouteURL.LIST_BOOK_JSP.toString()).forward(request, response);
	}

}
