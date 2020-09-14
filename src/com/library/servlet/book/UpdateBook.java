package com.library.servlet.book;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;
import com.library.model.Book;
import com.library.servlet.RouteURL;

@WebServlet("/update-book")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("id"));
		Optional<Book> book = new BookDao().get(id);
		if (book.isPresent()) {
			request.setAttribute("book", book.get());
			request.getRequestDispatcher(RouteURL.UPDATE_BOOK_JSP.toString()).forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("bookTitle");
		String author = request.getParameter("authorName");
		Book book = Book.builder().id(id).title(title).author(author).build();
		new BookDao().update(book);
		response.sendRedirect(RouteURL.LIST_BOOK.toString());
	}

}
