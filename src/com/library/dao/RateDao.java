package com.library.dao;

import com.library.model.Rate;
import com.library.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RateDao implements Dao<Rate> {
    private PreparedStatement statement;

    private static final String RATE_TABLE_NAME = TableNames.RATES.name();
    private static final String FIND_BY_ID = "select * from " + RATE_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + RATE_TABLE_NAME;
    private static final String INSERT = "insert into " + RATE_TABLE_NAME + " (user_id, book_id,score) values(?,?,?)";
    private static final String UPDATE = "update " + RATE_TABLE_NAME + " set user_id=?,book_id =?,score=? where( id = ?)";
    private static final String DELETE = "delete from " + RATE_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Rate> get(long id) {
        Rate rate = Rate.builder().build();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                rate.setUserId(res.getLong("user_id"));
                rate.setBookId(res.getLong("book_id"));
                rate.setScore(res.getString("score"));
                rate.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(rate);
    }

    @Override
    public List<Rate> getAll() {
        List<Rate> rates = new ArrayList<Rate>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Rate rate = Rate.builder().build();
                rate.setId(res.getLong("id"));
                rate.setUserId(res.getLong("user_id"));
                rate.setBookId(res.getLong("book_id"));
                rate.setScore(res.getString("rate"));

                rates.add(rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rates;
    }

    @Override
    public int save(Rate rate) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setLong(1, rate.getUserId());
            statement.setLong(2, rate.getBookId());
            statement.setString(3, rate.getScore());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Rate rate) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setLong(1, rate.getUserId());
            statement.setLong(2, rate.getBookId());
            statement.setString(3, rate.getScore());
            statement.setLong(4, rate.getId());

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
