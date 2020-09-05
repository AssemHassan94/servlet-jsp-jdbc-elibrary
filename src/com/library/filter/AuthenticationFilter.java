package com.library.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter initialized");
		System.out.println("check if the current user(session) is authenticated or no");

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// current session
		HttpSession session = req.getSession(false);

		// current url
		String uri = req.getServletPath();
		System.out.println("current uri : " + uri);

		boolean needLogin = uri.equals("/login") || uri.equals("/LoginServlet");

		if (isAuthenticated(req) && needLogin) {
			request.getRequestDispatcher("./jsp/main.jsp").forward(request, response);
			return;

		} else if (isAuthenticated(req) || needLogin || isResources(uri)) {
			chain.doFilter(request, response);
			return;
		}
		chain.doFilter(request, response);

//		res.sendRedirect("login");
	}

	private boolean isAuthenticated(HttpServletRequest request) {
		return request.getSession(false) != null && request.getSession().getAttribute("email") != null;
	}

	private boolean isResources(String uri) {
		return uri.startsWith("/css") || uri.startsWith("/img");
	}

}
