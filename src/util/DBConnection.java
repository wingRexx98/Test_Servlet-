package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection DBconn = null;
	private Connection conn = null;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// driver/username/password
			String url = "jdbc:mysql://localhost:3306/ServletTest";
			String userName = "root";
			String password = "1";
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	/**
	 * Create new instance of connection with db
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static DBConnection getInstance() throws SQLException {
		if (DBconn == null || DBconn.conn.isClosed()) {
			DBconn = new DBConnection();
		}
		return DBconn;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DBConnection.getInstance().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
