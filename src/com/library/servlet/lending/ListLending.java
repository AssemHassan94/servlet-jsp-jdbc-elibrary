package com.library.servlet.lending;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;
import com.library.dao.LendingDao;
import com.library.model.Book;
import com.library.model.Lending;
import com.library.servlet.RouteURL;

@WebServlet("/lending")
public class ListLending extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Lending> lends = new LendingDao().getAll();
		request.setAttribute("lends", lends);
		request.getRequestDispatcher(RouteURL.LIST_LEND_JSP.toString()).forward(request, response);
	}

}
