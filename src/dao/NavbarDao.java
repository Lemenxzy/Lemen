package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectCace;
import been.Navbar;

public class NavbarDao {
	
	public static List<Navbar> getNavbar(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Navbar> navbars = null;
		try {
			navbars = new ArrayList<Navbar>();
			connection = ConnectCace.getConnection();
			String sql = "SELECT id,name FROM nav WHERE is_delete = 0 ORDER BY shunxu ASC";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			Navbar navbar = null;
			while (rs.next()) {
				navbar = new Navbar();
				navbar.setId(rs.getInt("id"));
				navbar.setName(rs.getString("name"));
				navbars.add(navbar);
			}
			return navbars;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (connection!=null) {
					connection.close();
				}
				if (rs!=null) {
					rs.close();
				}
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
	
	
	
	
	public static Navbar getcontentnav(Integer id){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT ename,name FROM nav WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			Navbar navbar = null;
			if (rs.next()) {
				navbar = new Navbar();
				navbar.setName(rs.getString("name"));
				navbar.setEname(rs.getString("ename"));
			}
			return navbar;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (connection!=null) {
					connection.close();
				}
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
				if (rs!=null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	} 
	
	
	
}
