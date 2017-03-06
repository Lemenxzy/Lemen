package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectCace;
import been.Talking;

public class Talkingdao {

		public static boolean setTalking(Talking talking){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = ConnectCace.getConnection();
				String sql = "INSERT INTO talk_content(content,user_id,content_id,is_delete)VALUES(?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, talking.getContent());
				preparedStatement.setInt(2, talking.getUserId());
				preparedStatement.setInt(3, talking.getContentID());
				preparedStatement.setInt(4, talking.getIsDelete());
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
		
		
		public static List<Talking> findTalkings(Integer userid,Integer pageStart,Integer pagerEnd){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet rSet = null;
			List<Talking> talkings = null;
			try {
				//创建评论对象集合
				talkings = new ArrayList<Talking>();
				connection = ConnectCace.getConnection();
				String sql = "SELECT t.content,t.creat_time,t.content_id,t.id,u.username,u.user_header FROM talk_content t "+
							"JOIN `user` u ON u.id = t.user_id " +
							"WHERE t.is_delete = 0 AND t.content_id = ? " +
							"ORDER BY t.creat_time DESC "+
							"LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userid);
				preparedStatement.setInt(2, pageStart);
				preparedStatement.setInt(3, pagerEnd);
				rSet = preparedStatement.executeQuery();
				Talking talking = null;
				while (rSet.next()) {
					talking = new Talking();
					talking.setContent(rSet.getString("content"));
					talking.setCreatTime(rSet.getTimestamp("creat_time"));
					talking.setContentID(rSet.getInt("content_id"));
					talking.setId(rSet.getInt("id"));
					talking.setUsername(rSet.getString("username"));
					talking.setHeader(rSet.getString("user_header"));
					talkings.add(talking);
				}
				return talkings;
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
		
		
		public static int count(Integer userid){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet rSet = null;
			try {
				connection = ConnectCace.getConnection();
				String sql = "SELECT count(1) FROM talk_content t "+
							"JOIN `user` u ON u.id = t.user_id " +
							"WHERE t.is_delete = 0 AND t.content_id = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userid);
				rSet = preparedStatement.executeQuery();
				rSet.next();
				int count = rSet.getInt(1);
				return count;

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
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
