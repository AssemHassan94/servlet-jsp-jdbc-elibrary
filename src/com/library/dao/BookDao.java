package com.library.dao;

import com.library.model.Book;
import com.library.utility.DBConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book> {
    private PreparedStatement statement;

    private static final String BOOK_TABLE_NAME = TableNames.BOOKS.name();
    private static final String FIND_BY_ID = "select * from " + BOOK_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + BOOK_TABLE_NAME;
    private static final String INSERT = "insert into " + BOOK_TABLE_NAME + " (title,author) values(?,?)";
    private static final String UPDATE = "update " + BOOK_TABLE_NAME + " set title=?, author=? where( id = ?)";
    private static final String DELETE = "delete from " + BOOK_TABLE_NAME + " where id=?";

    @Override
    public Optional<Book> get(long id) {
        Book book = Book.builder().build();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                book.setId(id);
                book.setTitle(res.getString("title"));
                book.setAuthor(res.getString("author"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Book book = Book.builder().build();
                book.setId(res.getLong("id"));
                book.setTitle(res.getString("title"));
                book.setAuthor(res.getString("author"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int save(Book book) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());

            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }

    @Override
    public int update(Book book) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setLong(3, book.getId());

            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(DELETE);
            statement.setLong(1, id);
            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }

	
}
