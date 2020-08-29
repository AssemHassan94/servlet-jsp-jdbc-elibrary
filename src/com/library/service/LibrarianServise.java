package com.library.service;

import com.library.dao.Dao;
import com.library.dao.UserDao;
import com.library.model.User;

public class LibrarianServise {
	public Dao<User> userDao;

	public LibrarianServise() {
		this.userDao = new UserDao();

	}

	public void addLibrarian(String fname, String lname, String email, String password) {
		User b = User.builder().firstName(fname).lastName(lname).email(email).password(password).build();
		this.userDao.save(b);

	}
}