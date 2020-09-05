package com.library.servlet;

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

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long id = Long.parseLong(request.getParameter("id"));
		Optional<Book> book = new BookDao().get(id);
		System.out.println(book);
		if (book.isPresent()) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("jsp/update-book.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = (long) request.getAttribute("bookId");

		String title = request.getParameter("bookTitle");
		String author = request.getParameter("authorName");
		Book book = Book.builder().id(id).title(title).author(author).build();
		new BookDao().update(book);
		response.sendRedirect("/ListBook");
	}

}
