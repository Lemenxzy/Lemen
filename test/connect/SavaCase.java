package connect;

import gj.StringUrtil;

import org.junit.Test;

import dao.SavaUser;
import been.UserBeen;

public class SavaCase {
	@Test
	public void save(){
		UserBeen user = new UserBeen();
		
		user.setUsername("lemen");
		user.setPassword("123123");;
		user.setEmail("3231@qq.com");
		boolean flag = SavaUser.savauser(user);
		System.out.println(flag);
	}
	
	
	@Test
	public void main(){
		String id1 = "12";
		String id2 = StringUrtil.StringFilter(id1);
		id2 = StringUrtil.replaceBlank(id2);
		Integer id3 = Integer.parseInt(id2);
		System.out.println(id3);
	}
}
