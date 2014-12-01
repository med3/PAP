/**
 * 
 */
package com.ensimag.pap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ensimag.pap.model.User;

/**
 * @author truaro
 * 
 */
public class UserDAO {

	private final static String TABLE_NAME = "User";
	private final static String USER_ID = "user_id";
	private final static String USER_MAIL = "user_mail";
	private final static String USER_PASSWORD = "user_password";

	/**
	 * Insert a user into the database
	 * 
	 * @param user
	 * @throws DAOException
	 */
	public static void insert(User user) throws DAOException {
		String query = "INSERT INTO " + TABLE_NAME + "(" + USER_MAIL + ", "
				+ USER_PASSWORD + ") value (?, ?)";

		Connection conn;
		PreparedStatement ps;
		/*try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getMail());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (DAOException | SQLException e) {
			throw new DAOException("ERROR : Insert user impossible", e);
		}
		*/
	}

	public static User get(User user) throws DAOException {
		String query = "SELECT " + USER_ID + ", " + USER_MAIL + " FROM "
				+ TABLE_NAME + " WHERE UPPER(" + USER_MAIL
				+ ") = UPPER(?) AND " + USER_PASSWORD + " = ?";

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		/*try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getMail());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(USER_ID), rs.getString(USER_MAIL));
			} else {
				return null;
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException("ERROR : Get user impossible", e);
		}*/return new User(21, "");
	}
}
