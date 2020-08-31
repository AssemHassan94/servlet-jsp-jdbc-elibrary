package com.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.utility.DBConnection;

public class LoginDao {

	private PreparedStatement statement;

	private static final String USER_TABLE_NAME = TableNames.USERS.name();
	private static final String AUTH = "select email,password,role_id from " + USER_TABLE_NAME
			+ " where email=? and password=?";

	public String authenticate(String email, String password) {
		String emailDB;
		String passwordDB;
		Long role;

		try {
			statement = DBConnection.getConnection().prepareStatement(AUTH);
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				emailDB = resultSet.getString("email");
				passwordDB = resultSet.getString("password");
				role = resultSet.getLong("role_id");

				if (email.equals(emailDB) && password.equals(passwordDB) && role==1)
					return "Admin_Role";
				else if (email.equals(emailDB) && password.equals(passwordDB) && role==2)
					return "Librarian_Role";
				else if (email.equals(emailDB) && password.equals(passwordDB) && role==3)
					return "User_Role";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}

}
