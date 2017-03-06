package connect;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import been.Content;
import been.Indexmusic;
import dao.ConnectDao;
import dao.Musicdao;
import dao.Talkingdao;

public class Talking {
	@Test
	public void hald(){
		been.Talking   talking = new been.Talking();
		talking.setContent("sadsaddada是的撒");
		talking.setContentID(2);
		talking.setUserId(1);
		talking.setIsDelete(0);
		boolean comment = Talkingdao.setTalking(talking);
		if (comment) {
			System.out.println("评论成功！");
		}else{
			System.out.println("评论失败！");
		}
	}
	
	
	
	@Test
	public void hand(){
		List<been.Talking> talkings = Talkingdao.findTalkings(3, 0, 3);
		for (been.Talking talking : talkings) {
			System.out.println(talking.getContent());
		}
		int count = Talkingdao.count(2);
		System.out.println("====="+count);
	}
	
	
	@Test
	public void ed(){
		Indexmusic music = Musicdao.getMusic(1);
		System.out.println(music.getMusicSrc());
	}
	
	@Test
	
	public void fi(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		String dateString = str.substring(0,4);
		System.out.println(dateString);
		
	}


	
	
}
