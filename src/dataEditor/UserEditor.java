package dataEditor;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.*;

public class UserEditor {
	 
	public User getUserByAccout(String accout) {
		Connection connection = Linksql.getConnection();
		String sql = "select accout,pass from t_user where accout=?";
		try { 
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accout);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { 
				User user = new User(rs.getString("accout"), rs.getString("pass"));
				Linksql.close(connection, ps); 
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(User user) {
		Connection connection = Linksql.getConnection(); 
		String sql = "insert into t_user(accout,pass)values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getAccout());
			ps.setString(2, user.getPass());
			if (!ps.execute()) { 
				Linksql.close(connection, ps); 
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
}
