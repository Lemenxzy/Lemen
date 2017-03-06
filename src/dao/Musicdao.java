package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.ConnectCace;
import been.Indexmusic;

public class Musicdao {
	public static Indexmusic getMusic(Integer musicid){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		try {
			connection = ConnectCace.getConnection();
			String sql = "SELECT music_src FROM index_music "
						+"WHERE is_delete=1 AND music_id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, musicid);
			rSet = preparedStatement.executeQuery();
			Indexmusic music =null;
			if (rSet.next()) {
				music = new Indexmusic();
				music.setMusicSrc(rSet.getString("music_src"));
			}
			return music;
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
