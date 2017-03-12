package cn.victorlee.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/homework";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private Connection conn = null;
	
	public DBConnection() throws Exception {
		try {
			Class.forName(Driver);
			this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void close() throws Exception {
		if (null != this.conn) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}

}