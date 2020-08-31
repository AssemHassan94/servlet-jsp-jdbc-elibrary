package com.library.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.library.dao.LoginDao;

public class AuthenticationService {

	// create lazy init singleton
	private static AuthenticationService INSTANCE;

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
		Cookie emailCookie = new Cookie("email", email);
		emailCookie.setMaxAge(30 * 60);
		return emailCookie;
	}
}
