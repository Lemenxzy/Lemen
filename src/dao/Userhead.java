package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectCace;
import been.Headimg;

public class Userhead {
	public static List<Headimg> finduserHead(Integer pagestart,Integer pageend){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		List<Headimg> headimgs = null;
		try {
			headimgs = new ArrayList<Headimg>();
			connection = ConnectCace.getConnection();
			String sql = "SELECT id,url FROM head_img ORDER BY creat_time DESC"
					+ " LIMIT ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pagestart);
			preparedStatement.setInt(2, pageend);
			rSet = preparedStatement.executeQuery();
			Headimg headimg = null;
			while(rSet.next()){
				headimg = new Headimg();
				headimg.setId(rSet.getInt("id"));
				headimg.setUrl(rSet.getString("url"));
				headimgs.add(headimg);
			}
			return headimgs;
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
				if (rSet!=null) {
					rSet.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
