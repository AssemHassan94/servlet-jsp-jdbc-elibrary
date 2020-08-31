package com.library.service;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.LoginDao;

public class AuthenticationService {

	// create lazy init singleton
	private static AuthenticationService INSTANCE;

	private static String COOKIE_NAME = "email";

	public static AuthenticationService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AuthenticationService();
		}
		return INSTANCE;
	}

	public boolean isAuthenticated(String email, String password) {
		return true;

		// if (email.equals("a@a.com") && password.equals("test1234")) {
//			return true;
//		}
//		return false;
	}

	public Cookie addSession(HttpServletRequest request, String email) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30 * 60);
		Cookie emailCookie = new Cookie(COOKIE_NAME, email);
		emailCookie.setMaxAge(30 * 60);
		return emailCookie;
	}

	public void removeSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//JSESSIONID cookie is created/sent when session is created
		//Session is created when your code calls request.getSession() or request.getSession(true) for the first time
		//request.getSession(false) this will return you a current session or null.
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSIONID=" + cookie.getValue());
					break;
				}
			}
		}
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
