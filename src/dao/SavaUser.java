package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import been.UserBeen;
import connect.ConnectCace;

public class SavaUser {

	public static boolean savauser(UserBeen user){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "INSERT INTO `user`(username,password,email,user_header) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUserhead());
			int cont = preparedStatement.executeUpdate();
			return cont>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if (connection != null) {connection.close();}
				if (preparedStatement != null) {preparedStatement.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	public static UserBeen findemail(String email){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet reSet = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT email FROM `user` WHERE email = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			reSet = preparedStatement.executeQuery();
			UserBeen user = null;
			if (reSet.next()) {
				user = new UserBeen();
				user.setEmail(reSet.getString("email"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}finally{
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement !=null) {
					preparedStatement.close();
				}
				if (reSet!=null) {
					reSet.close();
				}
				
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	public static UserBeen finduname(String uname){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet reSet = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT username FROM `user` WHERE username = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uname);
			reSet = preparedStatement.executeQuery();
			UserBeen user = null;
			if (reSet.next()) {
				user = new UserBeen();
				user.setEmail(reSet.getString("username"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}finally{
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement !=null) {
					preparedStatement.close();
				}
				if (reSet!=null) {
					reSet.close();
				}
				
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}

