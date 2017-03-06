package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectCace {
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lemenboke1","root","xzyzmaichen123");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnct(Connection connection) {
		try {
			if (connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

