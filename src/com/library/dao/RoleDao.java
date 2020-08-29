package com.library.dao;

import com.library.model.Role;
import com.library.utility.DBConnection;
import lombok.Builder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Builder
public class RoleDao implements Dao<Role> {
    private PreparedStatement statement;

    private static final String ROLE_TABLE_NAME = TableNames.ROLES.name();
    private static final String FIND_BY_ID = "select * from " + ROLE_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + ROLE_TABLE_NAME;
    private static final String INSERT = "insert into " + ROLE_TABLE_NAME + " (role) values(?)";
    private static final String UPDATE = "update " + ROLE_TABLE_NAME + " set role=? where( id = ?)";
    private static final String DELETE = "delete from " + ROLE_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Role> get(long id) {
        Role role = Role.builder().build();

        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                role.setRole(res.getString("role"));
                role.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(role);
    }


    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Role role = Role.builder().build();
                role.setId(res.getLong("id"));
                role.setRole(res.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int save(Role role) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, role.getRole());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Role role) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, role.getRole());
            statement.setLong(2, role.getId());

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
