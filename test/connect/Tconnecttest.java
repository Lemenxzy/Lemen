package connect;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Tconnecttest {
	@Test
	public  void getConnection(){
		
		Connection connectcase;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectcase = DriverManager.getConnection("jdbc:mysql://localhost:3306/lemenboke1", "root", "xzyzmaichen123");
			System.out.println(connectcase);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}