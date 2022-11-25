package dataEditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class Linksql {
 
	private static final String user = "su"; 
	private static final String passwd = "135792468"; 
 
	private static final String url = "jdbc:mysql://159.75.246.16:3306/goodsmanage";
 
	private static final String driver = "com.mysql.cj.jdbc.Driver";
 
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 

 
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

 
	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

 
	public static void close(Connection connection, Statement statement, ResultSet rs) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
