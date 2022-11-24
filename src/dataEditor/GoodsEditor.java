package dataEditor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;




 
public class GoodsEditor {
	 
	public Goods getGoodsId(String id) {
		Connection connection = Linksql.getConnection();
		String sql = "select id,name,location,num,unit,price,tprice from goods where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { 
				Goods goods = new Goods(rs.getString("id"), rs.getString("name"),rs.getString("location"), rs.getFloat("num"),rs.getString("unit"), rs.getFloat("price"), rs.getFloat("tprice"));
				Linksql.close(connection, ps); 
				return goods;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

	 
	public boolean deleteGoodsId(String id) {
		Connection connection = Linksql.getConnection();
		String sql = "delete from goods where id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			if (!ps.execute()) { 
				Linksql.close(connection, ps); 
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	 
	public ArrayList<Goods> getGoodsList() {
		ArrayList<Goods> goodslist = new ArrayList<Goods>(); 
		Connection connection = Linksql.getConnection(); 
		String sql = "select id,name,location,num,unit,price,tprice from goods";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Goods goods = new Goods(rs.getString("id"), rs.getString("name"),rs.getString("location"), rs.getFloat("num"),rs.getString("unit"), rs.getFloat("price"), rs.getFloat("tprice"));
				goodslist.add(goods);
			}
			Linksql.close(connection, ps); 
			return goodslist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

	 
	public boolean addGoods(Goods goods) {
		Connection connection = Linksql.getConnection(); 
 
		String sql = "insert into goods(id,name,location,num,unit,price,tprice)values(?,?,?,?,?,?,?)";
		try {
			String id; 
			String name; 
			String location; 
			float num; 
			String unit; 
			float price; 
			float tprice; 
			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, goods.getId());
			ps.setString(2, goods.getName());
			ps.setString(3, goods.getLocation());
			ps.setFloat(4, goods.getNum());
			ps.setString(5, goods.getUnit());
			ps.setFloat(6, goods.getPrice());
			ps.setFloat(7, goods.getTprice());
			
			if (!ps.execute()) {
				Linksql.close(connection, ps); 
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}

	 
	public boolean updateGoods(Goods goods) {
		Connection connection = Linksql.getConnection(); 
		String sql = "update goods set name=?,location=?,num=?,unit=?,price=?,tprice=? where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getLocation());
			ps.setFloat(3, goods.getNum());
			ps.setString(4, goods.getUnit());
			ps.setFloat(5, goods.getPrice());
			ps.setFloat(6, goods.getTprice());
			ps.setString(7, goods.getId());
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
