/**
 * 
 */
package com.ensimag.pap.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ensimag.pap.util.PropertiesUtil;

/**
 * @author truaro
 * 
 */
public final class DBConnect {
	private Connection connection;
	private static DBConnect db;

	private final static String DB_URL = "db.url";
	private final static String DB_NAME = "db.name";
	private final static String DB_DRIVER = "db.driver";
	private final static String DB_USERNAME = "db.username";
	private final static String DB_PASSWORD = "db.password";

	private DBConnect() throws DAOException {
		try {
			String url = PropertiesUtil.getProperty(DB_URL);
			String dbName = PropertiesUtil.getProperty(DB_NAME);
			String driver = PropertiesUtil.getProperty(DB_DRIVER);
			String userName = PropertiesUtil.getProperty(DB_USERNAME);
			String password = PropertiesUtil.getProperty(DB_PASSWORD);

			Class.forName(driver).newInstance();
			connection = (Connection) DriverManager.getConnection(url + dbName,
					userName, password);
			connection.setAutoCommit(false);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException | IOException e) {
			throw new DAOException("ERROR: DB Initialisation", e);
		}
	}

	/**
	 * 
	 * @return Connection Database object
	 * @throws DAOException
	 */
	public static synchronized Connection getConnection() throws DAOException {
		if (db == null) {
			db = new DBConnect();
		}
		return db.connection;
	}
}
