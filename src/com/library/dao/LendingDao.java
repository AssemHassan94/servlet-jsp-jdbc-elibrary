package com.library.dao;

import com.library.model.Lending;
import com.library.utility.DBConnection;
import lombok.Builder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LendingDao implements Dao<Lending> {

	private PreparedStatement statement;

	private static final String LENDING_TABLE_NAME = TableNames.LENDING.name();
	private static final String FIND_BY_ID = "select * from " + LENDING_TABLE_NAME + " where id = ?";
	private static final String FIND_ALL = "select * from " + LENDING_TABLE_NAME;
	private static final String INSERT = "insert into " + LENDING_TABLE_NAME
			+ " (book_id, borrower_id, lend_date, return_date, status) values(?,?,?,?,?)";
	private static final String UPDATE = "update " + LENDING_TABLE_NAME
			+ " set book_id=?, borrower_id=?, staff_id=?, lend_date=?, return_date=?, status=? where( id = ?)";
	private static final String DELETE = "delete from " + LENDING_TABLE_NAME + " where id = ?";

	@Override
	public Optional<Lending> get(long id) {
		Lending lending = Lending.builder().build();
		try {
			statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
			statement.setLong(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				lending.setBookId(res.getLong("book_id"));
				lending.setBorrowerId(res.getLong("borrower_id"));
				lending.setLendDate(res.getDate("lend_date"));
				lending.setReturnDate(res.getDate("return_date"));
				lending.setStatus(res.getBoolean("status"));
				lending.setId(id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(lending);
	}

	@Override
	public List<Lending> getAll() {
		List<Lending> lending = new ArrayList<Lending>();
		try {
			statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
			ResultSet res = statement.executeQuery();
			while (res.next()) {

				Lending lend = Lending.builder().build();

				lend.setId(res.getLong("id"));
				lend.setBookId(res.getLong("book_id"));
				lend.setBorrowerId(res.getLong("borrower_id"));
				lend.setLendDate(res.getDate("lend_date"));
				lend.setReturnDate(res.getDate("return_date"));
				lend.setStatus(res.getBoolean("status"));

				lending.add(lend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lending;
	}

	@Override
	public int save(Lending lending) {
		try {
			statement = DBConnection.getConnection().prepareStatement(INSERT);
			statement.setLong(1, lending.getBookId());
			statement.setLong(2, lending.getBorrowerId());
			statement.setString(3, Instant.now().toString());
			statement.setString(4, Instant.now().toString());
			statement.setBoolean(5, lending.isStatus());
			int res = statement.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public int update(Lending lending) {
		try {
			statement = DBConnection.getConnection().prepareStatement(UPDATE);

			statement.setLong(1, lending.getBookId());
			statement.setLong(2, lending.getBorrowerId());
			statement.setString(3, Instant.now().toString());
			statement.setString(4, Instant.now().toString());
			statement.setBoolean(5, lending.isStatus());
			statement.setLong(6, lending.getId());

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
