package com.library.dao;

import com.library.model.User;
import com.library.utility.DBConnection;
import lombok.Builder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDao implements Dao<User> {

    private PreparedStatement statement;

    private static final String USER_TABLE_NAME = TableNames.USERS.name();
    private static final String FIND_BY_ID = "select * from " + USER_TABLE_NAME + " where id = ?";
    private static final String FIND_BY_USERNAME = "select * from " + USER_TABLE_NAME + " where username=?";
    private static final String FIND_ALL = "select * from " + USER_TABLE_NAME;
    private static final String INSERT = "insert into " + USER_TABLE_NAME + " (username,password, role) values(?,?,?)";
    private static final String UPDATE = "update " + USER_TABLE_NAME + " set username=?, password=?, role=? where( id = ?)";
    private static final String DELETE = "delete from " + USER_TABLE_NAME + " where id=?";
    
    
    @Override
    public Optional<User> get(long id) {
        User user = User.builder().build();

        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                user.setId(id);
                user.setUserName(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setRole(res.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> getByUserName(String username) {
        User user = User.builder().build();

        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_USERNAME);
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                user.setId(res.getLong("id"));
                user.setUserName(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setRole(res.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

        
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();


            while (res.next()) {
                User user = User.builder().build();
                user.setId(res.getLong("id"));
                user.setUserName(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setRole(res.getString("role"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int save(User user) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(User user) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setLong(4, user.getId());
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
