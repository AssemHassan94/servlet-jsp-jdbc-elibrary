package com.library.service;

import com.library.dao.BookDao;
import com.library.dao.Dao;
import com.library.model.Book;

public class BookService {
	
	public Dao<Book> bookDao;
	
	public BookService(){
		this.bookDao = new BookDao();
	}
	public void addNewBook(String title,String author) {
		Book b = Book.builder().title(title).author(author).build();
		this.bookDao.save(b);
	}
}
