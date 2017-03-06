package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectCace;
import been.Content;

public class ConnectDao {

	public static List<Content> findContents(Integer channelID,Integer pageNo,Integer pageEnd){
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet rs = null;
		List<Content> contents = null;
		try {
			contents = new ArrayList<Content>();
			connection = ConnectCace.getConnection();
			String sql = " SELECT id,title,description,img,author,keywords,hits,comment_hits,loves,creat_time "
						+" FROM boke_content "
						+" WHERE channel_id = ? and is_delete = 0 and statuss=1 "
						+" ORDER BY creat_time DESC "
						+" LIMIT ?,? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, channelID);
			preparedStatement.setInt(2, pageNo);
			preparedStatement.setInt(3, pageEnd);
			rs = preparedStatement.executeQuery();
			Content content = null;
			
			while (rs.next()) {
				content = new Content();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setDescription(rs.getString("description"));
				content.setImg(rs.getString("img"));
				content.setAuthor(rs.getString("author"));
				content.setKeywords(rs.getString("keywords"));
				content.setHits(rs.getInt("hits"));
				content.setCommentHits(rs.getInt("comment_hits"));
				content.setLoves(rs.getInt("loves"));
				content.setCreaTime(rs.getTimestamp("creat_time"));
				//添加数组
				contents.add(content);
			}
			return contents;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (connection!=null) {
					connection.close();
				}
				if (preparedStatement !=null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	
	public static List<Content> findContentss(Integer channelID){
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet rs = null;
		List<Content> contents = null;
		try {
			contents = new ArrayList<Content>();
			connection = ConnectCace.getConnection();
			String sql = " SELECT id,title,description,img,author,keywords,hits,comment_hits,loves,creat_time "
						+" FROM boke_content "
						+" WHERE channel_id = ? and is_delete = 0 and statuss=1 "
						+" ORDER BY creat_time DESC ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, channelID);
			rs = preparedStatement.executeQuery();
			Content content = null;
			while (rs.next()) {
				content = new Content();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setDescription(rs.getString("description"));
				content.setImg(rs.getString("img"));
				content.setAuthor(rs.getString("author"));
				content.setKeywords(rs.getString("keywords"));
				content.setHits(rs.getInt("hits"));
				content.setCommentHits(rs.getInt("comment_hits"));
				content.setLoves(rs.getInt("loves"));
				content.setCreaTime(rs.getTimestamp("creat_time"));
				//添加数组
				contents.add(content);
			}
			return contents;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (connection!=null) {
					connection.close();
				}
				if (preparedStatement !=null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	public static Content getContent(Integer id){
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet rs = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT nav.name,boke_content.content,boke_content.id,boke_content.title,boke_content.description,boke_content.music,"
					+ "boke_content.img,boke_content.author,boke_content.keywords,boke_content.hits,"
					+ "boke_content.comment_hits,boke_content.loves,boke_content.creat_time " 
					+ "FROM boke_content INNER JOIN nav ON "
					+ "boke_content.channel_id = nav.id "
					+ "WHERE boke_content.id = ? and boke_content.is_delete = 0 and boke_content.statuss=1;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			Content content = null;
			
			if (rs.next()) {
				content = new Content();
				content.setId(rs.getInt("boke_content.id"));
				content.setChannelName(rs.getString("name"));
				content.setTitle(rs.getString("title"));
				content.setDescription(rs.getString("description"));
				content.setImg(rs.getString("img"));
				content.setAuthor(rs.getString("author"));
				content.setKeywords(rs.getString("keywords"));
				content.setHits(rs.getInt("hits"));
				content.setContent(rs.getString("content"));
				content.setCommentHits(rs.getInt("comment_hits"));
				content.setLoves(rs.getInt("loves"));
				content.setCreaTime(rs.getTimestamp("creat_time"));
				content.setMusic(rs.getString("music"));
			}
			return content;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
}
