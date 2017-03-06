package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import been.UserBeen;
import connect.ConnectCace;

public class LoginData {
	public static UserBeen logindata(String email,String password){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT "+
						"id,"+
						"`password`,"+
						"username,"+
						"creat_time,"+
						"updata_time,"+
						"email,"+
						"is_delete,"+
						"user_id,"+
						"user_header"+
						" FROM `user` WHERE email = ? AND `password` = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			rSet = preparedStatement.executeQuery();
			UserBeen user = null;
			if (rSet.next()) {
				user = new UserBeen();
				user.setUsername(rSet.getString("username"));
				user.setUserId(rSet.getInt("user_id"));
				user.setEmail(rSet.getString("email"));
				user.setCreatTime(rSet.getTimestamp("creat_time"));
				user.setPassword(rSet.getString("password"));
				user.setUpdataTime(rSet.getDate("updata_time"));
				user.setId(rSet.getInt("id"));
				user.setUserhead(rSet.getString("user_header"));	
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
				if (rSet != null) {
					rSet.close();
				}
				if (preparedStatement  != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		UserBeen user = logindata("704694231@qq.com", "sCxKUOV2vFMQ4rGEakCp9w==");
		System.out.println(user.getUsername());
	}
	
}
