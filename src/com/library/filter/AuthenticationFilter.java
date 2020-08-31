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

		//current session
		HttpSession session = req.getSession(false);
		//current url
		String uri = req.getRequestURI();

		boolean isLoginURL = uri.endsWith("LoginServlet");
		boolean isLoginPage = uri.endsWith("login.html");
		
		if (session == null && !isLoginURL && !isLoginPage ) {
			System.out.println("Unauthorized access request");
			res.sendRedirect("login.html");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

	}

}
